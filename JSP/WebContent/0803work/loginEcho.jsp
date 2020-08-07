<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	
	if (pw.contains(id)) {
		out.println("로그인 되었습니다.");
	} else {
		out.println("로그인 불가입니다.");
	}
%>