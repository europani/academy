<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<%
	String req1 = request.getParameter("req1");
	String req2 = request.getParameter("req2");
	String ses = (String)session.getAttribute("ses");
	String pg = (String)pageContext.getAttribute("page");
	
	if (req1 == null) req1="---> ���� ���� �ʾҽ��ϴ�.";
	if (req2 == null) req2="---> ���� ���� �ʾҽ��ϴ�.";
	if (ses == null) ses="---> ���� ���� �ʾҽ��ϴ�.";
	if (pg == null) pg="---> ���� ���� �ʾҽ��ϴ�.";

%>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
page : <%=pg %><br>
request1 : <%=req1 %><br>
request2 : <%=req2 %><br>
session : <%=ses %><br>
</body>
</html>