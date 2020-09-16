package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import command.HeadAction;
import db.BoardDAO;

public class ListHandler extends HeadAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		
		return "/board/list.jsp";
	}
}
