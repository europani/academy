<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <%@ page errorPage="/error/viewErrorMessage.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>파라미터 출력</title>
</head>
<body>
name 파라미터 값 : <%= request.getParameter("name").toUpperCase() %>	<!-- null은 에러 X, NULL은 에러발생  --> 
</body>
</html>
<!-- 
에러 page 길이가 512btye보다 작으면 IE는 에러 page를 출력하지 않고 IE자체 에러 page를 출력함
 -->