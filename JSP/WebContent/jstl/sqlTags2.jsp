<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h2>SQL Tages2</h2>
<sql:update dataSource="${db}">
	UPDATE tblmember SET name=? WHERE id=?
	<sql:param value="${'우르곳'}" />
	<sql:param value="${'12345678'}" />
</sql:update>
업데이트를 하였습니다.<br>
<a href="sqlTags1.jsp">SELECT</a>
</body>
</html>