<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] studyArr = {"Java", "JSP", "Android", "Spring"};
	pageContext.setAttribute("study", studyArr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL의 Array1</h2>
<b>JAVA Program 과목</b><hr width="150" align="left" />
1. ${study[0]}<br>
2. ${study[1]}<br>
3. ${study[2]}<br>
4. ${study[3]}<br>
</body>
</html>