<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<% 
String name = request.getParameter("name");
String color = request.getParameter("color");
String fontColor = "black";
if (color.equals("black")) fontColor = "white";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	body {
		background-color : <%=color %>;
		color : <%= fontColor %>;
	}

</style>
</head>
<body>

<%=name %>���� �����ϴ� ���� <%=color %>�Դϴ�.
<script>
	alert('<%=name %>���� �����ϴ� ���� <%= color %> �Դϴ�.');
</script>
</body>
</html>