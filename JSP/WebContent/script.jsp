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
	out.print("���尴ü�� �̿��� ��� : " + declaration + "<p>");
	%>
	������ ���1 : <%= declaration %><p/>
	������ ���2: <%= decMethod() %><p/>
	��ũ��Ʈ���� ���: <%= scriptlet %><p/>
	
	<!-- JSP �ּ�1 : <%= comment %> --><p/>
	<%-- JSP �ּ�2 : <%= comment %> --%>

</body>
</html>