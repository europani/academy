<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="test" class="beans.SimpleBean" scope="page"></jsp:useBean>
<!--  SimpleBean test = new SimpleBean(); -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>������ �� ���α׷���</h1><br>
<jsp:setProperty name="test"  property="message" value="hi!"/>
Message : <jsp:getProperty name="test" property="message" />
</body>
</html>