package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HeadAction {
	public String board = "";
	public String boardid = "";
	public String pageNum = "";

	public void headProcess(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		
		request.setCharacterEncoding("EUC-KR");
		
		HttpSession session = request.getSession();
		
		if (request.getParameter("pageNum") != null) {	// 게시판 내 페이지 이동
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		if (request.getParameter("boardid") != null) {	// 게시판 이동
			session.setAttribute("boardid", request.getParameter("boardid"));
			session.setAttribute("pageNum", "1");
		}

		pageNum = (String)session.getAttribute("pageNum");		
		if (pageNum == null) pageNum = "1";
		
		boardid = (String)session.getAttribute("boardid");		
		if (boardid == null) boardid = "1";
		
		if (boardid.equals("1")) board = "공지사항";
		else if (boardid.equals("2")) board = "자유게시판";
		else if (boardid.equals("3")) board = "Q&A";
		else board = "회원입력";
		
	}
}
