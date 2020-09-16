package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import db.BoardDAO;
import db.BoardDTO;

public class ContentHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO dbPro = BoardDAO.getInstance();
		BoardDTO article = dbPro.getArticle(num, "1", true);	// ÀÓÀÇ°ª(boardid)
		
		request.setAttribute("article", article);
		
		return "/board/content.jsp";
	}

}
