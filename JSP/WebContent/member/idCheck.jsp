<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:useBean id="mMgr" class="member.MemberDAO" />
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	boolean result = mMgr.checkID(id);

	if (result) {
		out.println("는 사용 불가한 ID입니다");
	} else {
		out.println("는 사용 가능한 ID입니다");
	}
%>
