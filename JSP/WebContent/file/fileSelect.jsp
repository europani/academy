<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="frmName" enctype="multipart/form-data" method="post" action="viewPage.jsp">
	user<br>
	<input name="user"><br>
	title<br>
	<input name="title"><br>
	file<br>
	<input type="file" name="uploadFile"><br>
	<input type="submit" value="UPLOAD">
</form>
</body>
</html>