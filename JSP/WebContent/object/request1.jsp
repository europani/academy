<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc-kr"); %>
<%
	String name = request.getParameter("name");
	String studentNumber = request.getParameter("studentNumber");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");

	gender = (gender.equals("man")? "����" : "����");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Request Example1</h1>
�̸� : <%=name %><p>
�й� : <%=studentNumber %><p>
���� : <%=gender %><p>
�а� : <%=major %><p>
</body>
</html>