<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");	

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	session.setAttribute("idKey", id);
	session.setMaxInactiveInterval(60*5);	// 5mins

%>
<h1>Session Example1</h1>
<form method="post" action="/jsp/object/session1_1.jsp">
	1. ���� �����ϴ� ������?<br>
	<input type="radio" name="season" value="��">��
	<input type="radio" name="season" value="����">����
	<input type="radio" name="season" value="����">����
	<input type="radio" name="season" value="�ܿ�">�ܿ�<p>

	2. ���� �����ϴ� ������?<br>
	<input type="radio" name="fruit" value="watermelon">����
	<input type="radio" name="fruit" value="melon">���
	<input type="radio" name="fruit" value="peach">������
	<input type="radio" name="fruit" value="apple">���<p>
<input type="submit" value="�������">

</form>