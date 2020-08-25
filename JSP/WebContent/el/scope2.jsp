<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("msg", "꿈은 이루어 진다.");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL의 Scope1</h2>
msg(pageScope로 받은 값) : <b>${pageScope.msg}</b><p>
1~10 합 : <b><%=request.getAttribute("sum")%> = <%=request.getParameter("sum") %></b><p>		<!-- XXX -->
1~10 합 : <b>${requestScope.sum} = ${sum}</b><p>
</body>
</html>