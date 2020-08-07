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
<h1>나의 밥상</h1>
밥 : 
<%
	for(int i=0; i < rice.length; i++) {
		out.print(rice[i] + " ");
	}
%><br>
찌개 : 
<%
	for(int i=0; i < stew.length; i++) {
		out.print(stew[i] + " ");
	}
%><br>
국 : 
<%
	for(int i=0; i < tang.length; i++) {
		out.print(tang[i] + " ");
	}
%><br>
나물 : 
<%
	for(int i=0; i < namul.length; i++) {
		out.print(namul[i] + " ");
	}
%><br>
김치 : 
<%
	for(int i=0; i < gimchi.length; i++) {
		out.print(gimchi[i] + " ");
	}
%><br>
기타 : 
<%
	for(int i=0; i < etc.length; i++) {
		out.print(etc[i] + " ");
	}
%><br>
</body>
</html>