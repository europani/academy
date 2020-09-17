package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import command.HeadAction;

public class DeleteFormHandler extends HeadAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		headProcess(request, response);
		int num = Integer.parseInt(request.getParameter("num"));
		
		request.setAttribute("num", num);
		request.setAttribute("board", board);
		
		return "/board/deleteForm.jsp";
	}
}
