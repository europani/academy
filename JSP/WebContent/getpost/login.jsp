<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = (String)session.getAttribute("idKey");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Servlet ����</h1>
<%
	if (id != null) {
%>
<%=id %>�� �ݰ����ϴ�.
<a href="logout.jsp">�α׾ƿ�</a>
<%
	} else {
%>
<form method="post" action="/jsp/getpost/loginServlet">
id : <input name="id"><br>
pwd : <input type="password" name="pwd"><br>
<input type="submit" value="�α���">
</form>
<% } %>
</body>
</html>