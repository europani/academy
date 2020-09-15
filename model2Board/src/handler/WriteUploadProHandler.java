package handler;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.CommandHandler;
import db.BoardDAO;
import db.BoardDTO;

public class WriteUploadProHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			dao.insertArticle(article, "1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/board/writeUploadPro.jsp";
	}

}
