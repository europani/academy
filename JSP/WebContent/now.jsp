<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>현재 시간</title>
</head>
<body>

<% 
	Date now = new Date();
%>
<% 
	String bookTitle = "JSP 프로그래밍";
	String author = "최범균";
%>
현재시간 : 
<%= now %>
<br>
<b><%= bookTitle %></b>(<%= author %>)입니다.
</body>
</html>