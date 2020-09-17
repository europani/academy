package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import command.HeadAction;
import db.BoardDAO;

public class DeleteProHandler extends HeadAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		
		String num = request.getParameter("num");
		String passwd = request.getParameter("passwd");
		BoardDAO dbPro = BoardDAO.getInstance();
		int check = dbPro.deleteArticle(num, passwd, boardid);
		
		request.setAttribute("check", check);
		
		return "/board/deletePro.jsp";
	}

}
