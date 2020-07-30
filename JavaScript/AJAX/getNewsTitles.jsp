<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%	String[] titles = {
		"hello",
		"I'm fine thank you",
		"and you?"
};
for (int i = 0; i < titles.length; i++) {
%>
<% if (i == 0) { %><strong><% } %>
<%= titles[i] %>
<% if (i == 0) { %></strong><% } %>
<br/>
<%
}
%>