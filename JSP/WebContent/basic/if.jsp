<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<%!String msg;%>
<%
	String name = request.getParameter("name");
	String color = request.getParameter("color");
%>
�̸� :
<%=name%>
�����ϴ� �� :
<%=msg%>
<%
	if (color.equals("blue")) {
		msg = "�Ķ���";
	} else if (color.equals("red")) {
		msg = "������";
	} else if (color.equals("orange")) {
		msg = "��������";
	} else {
		msg = "��Ÿ";
	}
%>
<body bgcolor="<%=color %>" />
