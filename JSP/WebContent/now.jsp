<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �ð�</title>
</head>
<body>

<% 
	Date now = new Date();
%>
<% 
	String bookTitle = "JSP ���α׷���";
	String author = "�ֹ���";
%>
����ð� : 
<%= now %>
<br>
<b><%= bookTitle %></b>(<%= author %>)�Դϴ�.
</body>
</html>