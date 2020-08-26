<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="el.ELBean" />
<jsp:setProperty property="siteName" name="bean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL의 Beans</h2>
빈즈액션 태그<br>
사이트명 : <jsp:getProperty property="siteName" name="bean"/><p>

EL Beans<br>
사이트명 : ${bean.siteName} = ${bean.getSiteName()}
</body>
</html>