<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String name = request.getParameter("name");
	String itemcode = request.getParameter("itemcode");
	String specification = request.getParameter("specification");
	String qty = request.getParameter("qty");
	String price = request.getParameter("price");


%>
<!DOCTYPE html>
<body>
name : <%=name %><br>
itemcode : <%=itemcode %><br>
specification : <%=specification %><br>
qty : <%=qty %><br>
price : <%=price %><br>
</body>
