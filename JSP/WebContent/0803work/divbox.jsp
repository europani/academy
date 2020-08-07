<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");

	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String bgc = request.getParameter("backgroundColor");
	String num = request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	div {
		border : 1px solid black;
		width : <%=width%>px;
		height : <%=height%>px;
		background-color: <%=bgc%>;
	}
</style>
</head>
<body>

<script>
	let body = document.querySelector('body');
	let div = document.createElement('div');
	
	for (let i=0; i< <%=num%>; i++) {
		body.appendChild(div.cloneNode(true));
	}

</script>
</body>
</html>