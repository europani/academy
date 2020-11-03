<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form:form commandName="loginCommand">
<form:errors element="div" />
<label for="email">이메일</label>:
<input name="email" id="email" value="${loginCommand.email }">
<form:errors element="email" /><br>

<label for="password">암호</label>:
<input name="password" id="password">
<form:errors element="password" /><br>

<input type="submit" value="로그인">
</form:form>
<ul>
	<li>이메일/암호로 yuna@yuna.com/yuna 입력 or sanghwa@sanghwa.com/sanghwa </li>
</ul>
</body> 
</html>