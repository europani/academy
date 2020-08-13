<%@page import="member.MemberMgr"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="mgr" class="member.MemberMgr" />
<%
	String id = (String)session.getAttribute("idKey");
	int result = mgr.deleteMember(id);
	String msg = "회원탈퇴에 실패하였습니다.";
	String location = "login.jsp";
	if (result != 0) {
		msg = "회원탈퇴 처리되였습니다.";
		session.invalidate();
	}

%>
<script>
alert("<%=msg%>");
location.href="<%=location%>";
</script>

