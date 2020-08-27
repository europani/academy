<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource 
	driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe"
	user="scott"
	password="1111"
	var="db"
	scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h2>SQL Tages1</h2>
	<sql:query var="lists" dataSource="${db }">
		SELECT id, name FROM tblmember
	</sql:query>
	<c:forEach var="member" items="${lists.rows}">
		${member}<br>
	</c:forEach>

</body>
</html>