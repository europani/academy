<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String password = request.getParameter("password");

%>
<body>
writer : <%=writer %><p>
subject : <%=subject %><p>
content : <%=content %><p>
password : <%=password %><p>	

</body>