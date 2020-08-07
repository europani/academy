<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<h1>Declaration Example2</h1>
one + two ? <%=plusMethod()%><p>
String msg ? <%= msg%><p>
int three ? <%= three%>

<%! int one;
	int two = 1;

	public int plusMethod() {
		return one + two;
	}

	String msg;
	int three;%>