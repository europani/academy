<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:useBean id="mMgr" class="member.MemberDAO" />
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	boolean result = mMgr.checkID(id);

	if (result) {
		out.println("�� ��� �Ұ��� ID�Դϴ�");
	} else {
		out.println("�� ��� ������ ID�Դϴ�");
	}
%>
