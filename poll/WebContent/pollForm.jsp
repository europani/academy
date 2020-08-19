<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="poll.PollListDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="pDao" class="poll.PollDAO" />
<%
	int num = 0;
	if (!(request.getParameter("num") == null || request.getParameter("num").equals(""))) {
		num = Integer.parseInt(request.getParameter("num"));
	}
	PollListDTO plDto = pDao.getList(num);
	ArrayList<String> list = pDao.getItem(num);
	String question = plDto.getQuestion();
	int type = plDto.getType();
	int active = plDto.getActive();
%>
<link href="style.css" rel="stylesheet">
<form method="post" action="pollFormProc.jsp">
<table border="1" width="300">
	<tr>
		<td colspan="2">Q:<%=question %> </td>
	</tr>
	<tr>
		<td colspan="2">
			<%
				for (int i = 0; i< list.size(); i++) {
					String itemList = list.get(i);
					if (type == 1) {
						out.println("<input type=checkbox name='itemnum' value='"+i+"'>");
					} else {
						out.println("<input type=radio name='itemnum' value='"+i+"'>");
					}
					out.println(itemList + "<br>");
				}
			%>
		</td>
	</tr>
	<tr>
		<td>
			<%
				if (active == 1) {
					out.println("<input type=submit value='투표'>");
				} else {
					out.println("투표");
				}
			%>
		</td>
		<td>
			<input type="button" value="결과" onclick="javascript:window.open('pollView.jsp?num=<%=num%>', 'PollView', 'width=500, height=350')">
		</td>
	</tr>
</table>
<input type="hidden" name="num" value="<%=num%>">
</form>