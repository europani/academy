<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/filter/login.jsp">
	���̵�<input name="memberId">
	��й�ȣ<input type="password" name="password">
	<input type="submit" value="�α���">
</form>
</body>
</html>