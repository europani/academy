<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%= value1 %> + <%= value2 %> = <%= addResult %>
<br>
<%= value1 %> - <%= value2 %> = <%= subtractResult %>
<%!
	int value1 = 3;
	int value2 = 9;
	int addResult = add(value1, value2);
	int subtractResult = subtract(value1, value2);
	
	public int add(int a, int b) {
		return a+b;
	}
	public int subtract(int a, int b) {
		return a-b;
	}
%>

</body>
</html>