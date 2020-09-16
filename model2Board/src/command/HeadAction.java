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
		
		if (request.getParameter("pageNum") != null) {	// �Խ��� �� ������ �̵�
			session.setAttribute("pageNum", request.getParameter("pageNum"));
		}
		if (request.getParameter("boardid") != null) {	// �Խ��� �̵�
			session.setAttribute("boardid", request.getParameter("boardid"));
			session.setAttribute("pageNum", "1");
		}

		pageNum = (String)session.getAttribute("pageNum");		
		if (pageNum == null) pageNum = "1";
		
		boardid = (String)session.getAttribute("boardid");		
		if (boardid == null) boardid = "1";
		
		if (boardid.equals("1")) board = "��������";
		else if (boardid.equals("2")) board = "�����Խ���";
		else if (boardid.equals("3")) board = "Q&A";
		else board = "ȸ���Է�";
		
	}
}
