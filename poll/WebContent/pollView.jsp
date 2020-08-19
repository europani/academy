<%@page import="java.util.Random"%>
<%@page import="poll.PollListDTO"%>
<%@page import="poll.PollItemDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="pDao" class="poll.PollDAO" />
<%
	int num = 0;
	if (request.getParameter("num") != null) {
		num = Integer.parseInt(request.getParameter("num"));
	}
	int sum = pDao.sumCount(num);
	ArrayList<PollItemDTO> list = pDao.getView(num);
	PollListDTO plDto = pDao.getList(num);
	String question = plDto.getQuestion();
	Random r = new Random();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
	<div align="center">
		<table border="1" width="400">
			<tr><td colspan="4"><b>Q:<%=question %></b></td></tr>
			<tr>
				<td colspan="3"><b>총투표자: <%=sum %>명</b></td>
				<td width="40">count</td>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
					PollItemDTO piDto = list.get(i);
					String[] item = piDto.getItem();
					int rgb = r.nextInt(255 * 255 * 255);
					String rgbt = Integer.toHexString(rgb);
					String hRGB = "#" + rgbt;
					int count = piDto.getCount();
					int radio = (new Double(Math.ceil((double)count / sum * 100))).intValue();
			%>
			<tr>
				<td width="20" align="center"><%=i+1 %></td>
				<td width="120"><%=item[0] %></td>
				<td>
					<table width="<%=radio%>" height="15">
						<tr>
							<td bgcolor="<%=hRGB%>"></td>
						</tr>
					</table>
				</td>
				<td width="40" <%=count %>>
				</td>
			</tr>
			<%} %>
		</table>
		<p>
		<a href="javascript:window.close()">닫기</a>
	</div>
</body>
</html>