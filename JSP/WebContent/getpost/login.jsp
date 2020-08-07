<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = (String)session.getAttribute("idKey");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Servlet 세션</h1>
<%
	if (id != null) {
%>
<%=id %>님 반갑습니다.
<a href="logout.jsp">로그아웃</a>
<%
	} else {
%>
<form method="post" action="/jsp/getpost/loginServlet">
id : <input name="id"><br>
pwd : <input type="password" name="pwd"><br>
<input type="submit" value="로그인">
</form>
<% } %>
</body>
</html>