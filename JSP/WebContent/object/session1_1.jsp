<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");	

	String season =request.getParameter("season");
	String fruit =request.getParameter("fruit");
	String id =(String)session.getAttribute("idKey");
	
	String sessionId = session.getId();
	int intervalTime = session.getMaxInactiveInterval();
	
	if(id != null) {

%>
<h1>Session Example1</h1>
<%=id %>���� �����ϴ� ������ ������<p>
<%=season %>�� <%=fruit%> �Դϴ�.<p>

���� ID : <%=sessionId%><p>
���� ���� �ð� : <%=intervalTime%>��<p>
<%
	session.invalidate();
	} else {
		out.println("������ �ð��� ����� �Ͽ��ų� �ٸ� ������ ���� X");
	}
%>