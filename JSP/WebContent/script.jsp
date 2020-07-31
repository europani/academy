<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<body>
	<h1>Script Example1</h1>
	<%! String declaration = "Declaration";

	public String decMethod() {
		return declaration;
	}%>
	<%
		String scriptlet = "Scriptlet";
	String comment = "Comment";
	out.print("내장객체를 이용한 출력 : " + declaration + "<p>");
	%>
	선언문의 출력1 : <%= declaration %><p/>
	선언문의 출력2: <%= decMethod() %><p/>
	스크립트릿의 출력: <%= scriptlet %><p/>
	
	<!-- JSP 주석1 : <%= comment %> --><p/>
	<%-- JSP 주석2 : <%= comment %> --%>

</body>
</html>