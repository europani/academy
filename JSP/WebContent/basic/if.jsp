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
이름 :
<%=name%>
좋아하는 색 :
<%=msg%>
<%
	if (color.equals("blue")) {
		msg = "파란색";
	} else if (color.equals("red")) {
		msg = "붉은색";
	} else if (color.equals("orange")) {
		msg = "오렌지색";
	} else {
		msg = "기타";
	}
%>
<body bgcolor="<%=color %>" />
