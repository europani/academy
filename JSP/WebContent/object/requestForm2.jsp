<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String pg = (String)pageContext.getAttribute("page");
	if (pg == null) pg="---> ���� ���� �ʾҽ��ϴ�.";

%>
page : <%=pg %><br>
<form method="post" action="requestCheck.jsp">
<input type="hidden" name="req1" value="<%=request.getParameter("req1") %>">	<!-- ���� �Ѿ�� req1�� hidden���� ���ܼ� ���� -->
req2 : <input type="text" name="req2">
<input type="submit" value="������">
</body>
</html>