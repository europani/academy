<%@page import="poll.PollListDTO"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="pDao" class="poll.PollDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
	<div align="center">
		<h2>��ǥ���α׷�</h2>
		<hr width="600" />
		<b>������</b>
		<jsp:include page="pollForm.jsp" />
		<hr width="600" />
		<b>��������Ʈ</b>
		<table>
			<tr>
				<td>
					<table width="500" border="1">
						<tr>
							<td align="center"><b>��ȣ</b></td>
							<td><b>����</b></td>
							<td><b>������~������</b></td>
						</tr>
						<%
							Vector<PollListDTO> vlist =pDao.getAllList();
							int count = vlist.size();
							for (int i = 0; i < vlist.size(); i++) {
								PollListDTO pDto = vlist.get(i);
								int num = pDto.getNum();
								
								String question = pDto.getQuestion();
								String sdate = pDto.getSdate();
								String edate = pDto.getEdate();
								out.println("<tr><td align='center'>" + count + "</td>");
								out.println("<td><a href='pollList.jsp?num=" + num + "'>" + question + "</a></td>");
								out.println("<td>" + sdate + "~" + edate + "</td></tr>");
								count = count - 1;
							}
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right"><a href="pollInsert.jsp">�����ۼ��ϱ�</a></td>
			</tr>
		</table>
	</div>
</body>
</html>