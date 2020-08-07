<%@page import="java.util.Date"%>
<%@page contentType="text/html; charset=EUC-KR"
	session="true"
	buffer="16kb"
	autoFlush="true"
	isThreadSafe="true"
%>
<h1>Directive Example2</h1>
<%
	Date date = new Date();
%>
<%= date.toLocaleString() %>