<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<h3>MultipartFile 사용</h3>
<form action="multipartFile" method="post" enctype="multipart/form-data">
	제목: <input name="title"><br>
	파일: <input type="file" name="f"><br>
	<input type="submit" value="전송">
</form>
<hr>
<h3>MultipartHttpServletRequest 사용</h3>
<form action="multipartHttpServletRequest" method="post" enctype="multipart/form-data">
	제목: <input name="title"><br>
	파일: <input type="file" name="f"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>
<hr>
<h3>Command객체 사용</h3>
<form action="commandObject" method="post" enctype="multipart/form-data">
	제목: <input name="title"><br>
	파일: <input type="file" name="f"><br>
	<input type="submit" value="전송">
</form>
