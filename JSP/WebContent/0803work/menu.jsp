<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");

	String[] rice = request.getParameterValues("rice");
	String[] stew = request.getParameterValues("stew");
	String[] tang = request.getParameterValues("tang");
	String[] namul = request.getParameterValues("namul");
	String[] gimchi = request.getParameterValues("gimchi");
	String[] etc = request.getParameterValues("etc");
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���� ���</h1>
�� : 
<%
	for(int i=0; i < rice.length; i++) {
		out.print(rice[i] + " ");
	}
%><br>
� : 
<%
	for(int i=0; i < stew.length; i++) {
		out.print(stew[i] + " ");
	}
%><br>
�� : 
<%
	for(int i=0; i < tang.length; i++) {
		out.print(tang[i] + " ");
	}
%><br>
���� : 
<%
	for(int i=0; i < namul.length; i++) {
		out.print(namul[i] + " ");
	}
%><br>
��ġ : 
<%
	for(int i=0; i < gimchi.length; i++) {
		out.print(gimchi[i] + " ");
	}
%><br>
��Ÿ : 
<%
	for(int i=0; i < etc.length; i++) {
		out.print(etc[i] + " ");
	}
%><br>
</body>
</html>