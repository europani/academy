<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Expression Example2</h1>
	<%
	Date date = new Date();
int hour = date.getHours();
int one = 10;
int two = 12;
%>
<%!
	public int operation(int i, int j) {
	return i > j? i : j;
}

%>
������ ����? ����? <br><b><%= (hour >12)? "����":"����" %></b><br>
one�� two�� ū ���ڴ�??<br><b><%= operation(one, two)%></b>
</body>
</html>