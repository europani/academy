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
	cookie.setMaxAge(60);	// 1��
	cookie.setValue("Melon");
	response.addCookie(cookie);		// ��Ű�� ���� -> Ŭ���̾�Ʈ
%>
<body>
<h1>Example Cookie</h1>
��Ű�� ����ϴ�.<br>
��Ű ������ <a href="tasteCookie.jsp">�����!!</a>
</body>
</html>