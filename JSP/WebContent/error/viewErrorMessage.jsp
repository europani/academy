<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �߻�</title>
</head>
<body>
��û ó�� �������� ������ �߻��Ͽ����ϴ�.<br>
���� �ð� ���� ������ �ذ��ϵ��� �ϰڽ��ϴ�.
<p>
���� Ÿ�� : <%= exception.getClass().getName() %><br>
���� �޽��� : <%=exception.getMessage() %>
</body>
</html>