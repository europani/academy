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
	if (pg == null) pg="---> 전달 되지 않았습니다.";

%>
page : <%=pg %><br>
<form method="post" action="requestCheck.jsp">
<input type="hidden" name="req1" value="<%=request.getParameter("req1") %>">	<!-- 먼저 넘어온 req1을 hidden으로 숨겨서 전송 -->
req2 : <input type="text" name="req2">
<input type="submit" value="보내기">
</body>
</html>