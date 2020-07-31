<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="/jsp/viewParameter.jsp" method="post">
	이름 : <input type="text" name="name" size="10"> <br>
	주소 : <input type="text" name="address" size="30"> <br>
	좋아하는 동물 :
		 <input type="checkbox" name="pet" value="dog"> 강아지
		 <input type="checkbox" name="pet" value="cat"> 고양이
		 <input type="checkbox" name="pet" value="pig"> 돼지
	<br>
	<input type="submit" value="전송하기">
	</form>
</body>
</html>