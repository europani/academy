
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="com.semosam.dao.memberDAO"%>
<%@page import="com.semosam.dto.memberDTO"%>
<%
	request.setCharacterEncoding("EUC-KR");

	String email = (String) session.getAttribute("idKey");
	String pwd = request.getParameter("pwd");
	memberDAO mdao = new memberDAO();
	/* memberDTO dto = dao.getMember(email); */
	
	int check = mdao.deleteMember(email, pwd);
	if (check == 1) {
%>
<meta http-equiv="Refresh" content="0, url=/JSP_PROJECT/nohead/logoutProc.jsp">
<%
	} else {
%>
<script language="JavaScript">
	alert("비밀번호가 맞지 않습니다.");
	history.go(-1);
</script>
<%
	}
%>
