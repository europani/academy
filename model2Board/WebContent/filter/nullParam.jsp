<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>NullParameterFilter 테스트</title>
</head>
<body>
id 파라미터 : <%=request.getParameter("id") %><br>
name 파라미터 : <%=request.getParameter("name") %><br>
member 파라미터 : <%=request.getParameter("member") %><br>
</body>
</html>