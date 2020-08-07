<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	String name = "JSPStudy";
    	String bloodType = request.getParameter("bloodType"); 
    	
    %>
<h1><%= bloodType %>Çü Tag Example2</h1>
<jsp:forward page='<%=bloodType + ".jsp" %>'>
	<jsp:param value="<%=name %>" name="name"/>
</jsp:forward>