package handler;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.CommandHandler;
import command.HeadAction;
import db.BoardDAO;
import db.BoardDTO;

public class UpdateProHandler extends HeadAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

		return "/board/updatePro.jsp";
	}
}
