<%@page import="member.MemberMgr"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="mgr" class="member.MemberMgr" />
<%
	String id = (String)session.getAttribute("idKey");
	int result = mgr.deleteMember(id);
	String msg = "ȸ��Ż�� �����Ͽ����ϴ�.";
	String location = "login.jsp";
	if (result != 0) {
		msg = "ȸ��Ż�� ó���ǿ����ϴ�.";
		session.invalidate();
	}

%>
<script>
alert("<%=msg%>");
location.href="<%=location%>";
</script>

