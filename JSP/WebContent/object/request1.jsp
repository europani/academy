<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc-kr"); %>
<%
	String name = request.getParameter("name");
	String studentNumber = request.getParameter("studentNumber");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");

	gender = (gender.equals("man")? "남자" : "여자");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Request Example1</h1>
이름 : <%=name %><p>
학번 : <%=studentNumber %><p>
성별 : <%=gender %><p>
학과 : <%=major %><p>
</body>
</html>