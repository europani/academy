<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <%@ page errorPage="/error/viewErrorMessage.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Ķ���� ���</title>
</head>
<body>
name �Ķ���� �� : <%= request.getParameter("name").toUpperCase() %>	<!-- null�� ���� X, NULL�� �����߻�  --> 
</body>
</html>
<!-- 
���� page ���̰� 512btye���� ������ IE�� ���� page�� ������� �ʰ� IE��ü ���� page�� �����
 -->