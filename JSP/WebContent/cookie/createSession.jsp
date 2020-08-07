<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>세션 생성</title>
</head>
<body>
<%
	String id = "skyblue";
	String pwd = "1111";
	
	session.setAttribute("idKey", id);
	session.setAttribute("pwdKey", pwd);
	
%>
세션이 생성되었습니다.<br>
세션 내용은 <a href="viewSessionInfo.jsp">여기로!!</a>
</body>
</html>