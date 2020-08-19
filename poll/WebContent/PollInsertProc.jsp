<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="pDao" class="poll.PollDAO" />
<jsp:useBean id="plDto" class="poll.PollListDTO" />
<jsp:setProperty property="*" name="plDto"/>
<jsp:useBean id="piDto" class="poll.PollItemDTO" />
<jsp:setProperty property="*" name="piDto"/>
<%
	String sdate = request.getParameter("sdateY") +"-" + request.getParameter("sdateM") + "-" + request.getParameter("sdateD");
	String edate = request.getParameter("edateY") +"-" + request.getParameter("edateM") + "-" + request.getParameter("edateD");
	plDto.setSdate(sdate);
	plDto.setEdate(edate);
	
	boolean flag = pDao.insertPoll(plDto, piDto);
	String msg = "설문 추가에 실패 하였습니다.";
	String url = "pollInsert.jsp";
	if (flag) {
		msg = "설문 추가 되었습니다.";
		url = "pollList.jsp";
	}
%>
<script>
	alert("<%=msg%>");
	location.href='<%=url%>';
</script>
