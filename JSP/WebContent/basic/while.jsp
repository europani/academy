<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>While Example</h1>
<% 
	String msg = request.getParameter("msg");
	String number = request.getParameter("number");	
%>
<%
	int i = 0;
	while (i < Integer.parseInt(number)) {
%>
		<%= msg%><br>
<%		i++;
	}
%>