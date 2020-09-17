package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import command.HeadAction;
import db.BoardDAO;
import db.BoardDTO;

public class UpdateFormHandler extends HeadAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardDTO article = dbPro.getArticle(num, boardid, false);
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		request.setAttribute("board", board);
		
		return "/board/updateForm.jsp";
	}

}
