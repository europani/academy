<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Cook Cookie</title>
</head>
<%
	String cookieName = "myCookie";
	Cookie cookie = new Cookie(cookieName, "Apple");
	cookie.setMaxAge(60);	// 1분
	cookie.setValue("Melon");
	response.addCookie(cookie);		// 쿠키를 서버 -> 클라이언트
%>
<body>
<h1>Example Cookie</h1>
쿠키를 만듭니다.<br>
쿠키 내용은 <a href="tasteCookie.jsp">여기로!!</a>
</body>
</html>