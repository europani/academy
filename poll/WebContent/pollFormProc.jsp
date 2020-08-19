<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="pDao" class="poll.PollDAO" />
<%
	request.setCharacterEncoding("EUC-KR");
	int num = Integer.parseInt(request.getParameter("num"));
	String[] itemnum = request.getParameterValues("itemnum");
	boolean flag = pDao.updatePoll(num, itemnum);
	
	String msg = "투표가 등록되지 않았습니다.";
	if (flag) {
		msg = "투표가 정상 등록되었습니다.";
	}
%>
<script>
	alert("<%=msg%>");
	location.href='pollList.jsp?num=<%=num%>';
</script>