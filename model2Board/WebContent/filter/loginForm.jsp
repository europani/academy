<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/filter/login.jsp">
	아이디<input name="memberId">
	비밀번호<input type="password" name="password">
	<input type="submit" value="로그인">
</form>
</body>
</html>