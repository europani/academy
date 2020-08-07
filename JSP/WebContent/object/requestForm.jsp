<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<%
	session.setAttribute("ses", "session text 입니다.");
	pageContext.setAttribute("page", "page text 입니다.");

%>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="requestForm2.jsp">
req1 : <input type="text" name="req1">
<input type="submit" value="보내기">

</form>
</body>
</html>