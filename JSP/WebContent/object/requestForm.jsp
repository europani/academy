<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<%
	session.setAttribute("ses", "session text �Դϴ�.");
	pageContext.setAttribute("page", "page text �Դϴ�.");

%>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="requestForm2.jsp">
req1 : <input type="text" name="req1">
<input type="submit" value="������">

</form>
</body>
</html>