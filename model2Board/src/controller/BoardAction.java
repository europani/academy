package controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.Action;
import db.BoardDAO;
import db.BoardDTO;

public class BoardAction extends Action {
	public String board = "";
	public String boardid = "";
	public String pageNum = "";

	public void headProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("EUC-KR");

		HttpSession session = request.getSession();

		if (request.getParameter("pageNum") != null) { // 게시판 내 페이지 이동
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		if (request.getParameter("boardid") != null) { // 게시판 이동
			session.setAttribute("boardid", request.getParameter("boardid"));
			session.setAttribute("pageNum", "1");
		}

		pageNum = (String) session.getAttribute("pageNum");
		if (pageNum == null)
			pageNum = "1";

		boardid = (String) session.getAttribute("boardid");
		if (boardid == null)
			boardid = "1";

		if (boardid.equals("1"))
			board = "공지사항";
		else if (boardid.equals("2"))
			board = "자유게시판";
		else if (boardid.equals("3"))
			board = "Q&A";
		else
			board = "회원입력";
	}

	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		int pageSize = 5;

		String category = request.getParameter("category");
		String sentence = request.getParameter("sentence");

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		List articleList = null;
		BoardDAO dbPro = BoardDAO.getInstance();
		count = dbPro.getArticleCount(boardid, category, sentence);
		if (count > 0) {
			articleList = dbPro.getArticles(startRow, endRow, boardid, category, sentence);
		}
		number = count - (currentPage - 1) * pageSize;

		int bottomLine = 3;
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;

		if (count > 0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
			endPage = startPage + bottomLine - 1;

			if (endPage > pageCount) {
				endPage = pageCount;
			}
		}

		request.setAttribute("pageSize", pageSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("number", number);
		request.setAttribute("articleList", articleList);
		request.setAttribute("board", board);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		return "/view/board/list.jsp";
	}

	public String content(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO dbPro = BoardDAO.getInstance();
		BoardDTO article = dbPro.getArticle(num, boardid, true);

		request.setAttribute("article", article);

		return "/view/board/content.jsp";
	}

	public String writeUploadForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int num = 0, ref = 1, re_step = 0, re_level = 0;

		if (request.getParameter("num") != null) {
			num = Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}

		request.setAttribute("num", num);
		request.setAttribute("ref", ref);
		request.setAttribute("re_step", re_step);
		request.setAttribute("re_level", re_level);
		
		return "/view/board/writeUploadForm.jsp";
	}

	public String writeUploadPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		
		String realFolder = "";
		String saveFolder = "uploadFile";
		String encType = "EUC-KR";
		int maxSize = 10 * 1024 * 1024;//10M
		realFolder = request.getRealPath(saveFolder);
		try {MultipartRequest multi = 
			new MultipartRequest(request, realFolder, maxSize, encType,
			new DefaultFileRenamePolicy());
			BoardDTO article = new BoardDTO();
			System.out.println(multi);
			Enumeration files = multi.getFileNames();
			if (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				File file = multi.getFile(name);
				if (file != null) {
					article.setFilename(file.getName());
					article.setFilesize((int) file.length());
				} else {
					article.setFilename("");
					article.setFilesize(0);
				}
			}
			System.out.println(article);
		 	article.setNum(Integer.parseInt(multi.getParameter("num")));
			article.setRef(Integer.parseInt(multi.getParameter("ref")));
			article.setRe_step(Integer.parseInt(multi.getParameter("re_step")));
			article.setRe_level(Integer.parseInt(multi.getParameter("re_level")));
		 	
		    article.setWriter(multi.getParameter("writer"));
			article.setContent(multi.getParameter("content"));
			article.setPasswd(multi.getParameter("passwd"));
			article.setSubject(multi.getParameter("subject"));
			article.setEmail(multi.getParameter("email"));
			article.setBoardid((String) request.getSession().getAttribute("boardid"));
			article.setIp(request.getRemoteAddr());
			BoardDAO dao = BoardDAO.getInstance();
			System.out.println(article);
			dao.insertArticle(article, boardid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/view/board/writeUploadPro.jsp";
	}
	
	public String updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardDTO article = dbPro.getArticle(num, boardid, false);
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		request.setAttribute("board", board);
		
		return "/view/board/updateForm.jsp";
	}
	
	public String updatePro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String realFolder = "";
		String saveFolder = "uploadFile";
		String encType = "euc-kr";
		int maxSize = 10 * 1024 * 1024;// 10M
		realFolder = request.getRealPath(saveFolder);
		int check = -1;
		try {
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
			BoardDTO article = new BoardDTO();
			Enumeration files = multi.getFileNames();
			if (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				File file = multi.getFile(name);
				if (file != null) {
					article.setFilename(file.getName());
					article.setFilesize((int) file.length());
				} else {
					article.setFilename(multi.getParameter("oldFile"));
				}
				article.setNum(Integer.parseInt(multi.getParameter("num")));
				article.setWriter(multi.getParameter("writer"));
				article.setContent(multi.getParameter("content"));
				article.setPasswd(multi.getParameter("passwd"));
				article.setSubject(multi.getParameter("subject"));
				article.setEmail(multi.getParameter("email"));
				article.setBoardid((String) request.getSession().getAttribute("boardid"));
				article.setIp(request.getRemoteAddr());
				BoardDAO dbPro = BoardDAO.getInstance();
				check = dbPro.updateArticle(article, boardid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("check", check);

		return "/view/board/updatePro.jsp";
	}
	
	public String deleteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		int num = Integer.parseInt(request.getParameter("num"));
		
		request.setAttribute("num", num);
		request.setAttribute("board", board);
		
		return "/view/board/deleteForm.jsp";
	}
	
	public String deletePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		
		String num = request.getParameter("num");
		String passwd = request.getParameter("passwd");
		BoardDAO dbPro = BoardDAO.getInstance();
		int check = dbPro.deleteArticle(num, passwd, boardid);
		
		request.setAttribute("check", check);
		
		return "/view/board/deletePro.jsp";
	}
	
}
