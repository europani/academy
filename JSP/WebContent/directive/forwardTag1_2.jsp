<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	String id = request.getParameter("id");
  	 	String pwd = request.getParameter("pwd");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Forward Tag Example1</h1>
당신의 아이디는 <%=id %> 입니다.
당신의 비밀번호는 <%=pwd %> 입니다.
</body>
</html>