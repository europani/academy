<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h1>For example</h1>
1~10까지 합은?<p>
<% 
	int i,sum = 0;
	for (i = 1; i <= 10; i++) {
		if (i <10) {
%>
		<%= (i + " +") %>
<%		
		} else {
%>		<%= (i + " =") %>	
<%		}
		sum += i;
	}
%>
<%= sum %>