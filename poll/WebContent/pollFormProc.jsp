<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="pDao" class="poll.PollDAO" />
<%
	request.setCharacterEncoding("EUC-KR");
	int num = Integer.parseInt(request.getParameter("num"));
	String[] itemnum = request.getParameterValues("itemnum");
	boolean flag = pDao.updatePoll(num, itemnum);
	
	String msg = "��ǥ�� ��ϵ��� �ʾҽ��ϴ�.";
	if (flag) {
		msg = "��ǥ�� ���� ��ϵǾ����ϴ�.";
	}
%>
<script>
	alert("<%=msg%>");
	location.href='pollList.jsp?num=<%=num%>';
</script>