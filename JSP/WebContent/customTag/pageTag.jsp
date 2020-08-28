<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/PageTag.tld" %>
<%
	int start = 1;
	int end = 10;
	int nowPage = 1;
	if (request.getParameter("nowPage") != null) {
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 페이지는 <b><%=nowPage%></b>입니다. <br>
<tag:page from="<%=start %>" to="<%=end%>"/>
</body>
</html>