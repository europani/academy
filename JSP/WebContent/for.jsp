<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>For example</title>
</head>
<body>
1에서 10까지 합은?<p>
<%
	int i, sum = 0;
	for(i = 1; i <= 10; i++) {
		if(i<10) {
%>
	<%= (i + "+") %>
<% 		
	} else {
		out.println(i + " = ");
	}
	sum += i;
	}
%>
<%= sum%>
</body>
</html>