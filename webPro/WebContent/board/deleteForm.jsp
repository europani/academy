<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String num = request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ���</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<p class="w3-left" style="padding-left: 30px;"><%=board%></p>
	<div class="w3-container">
		<b>�ۻ���<br>
			<form method="post" name="delForm" action="deletePro.jsp">
				<table class="table-bordered" width="360">
					<tr height="30">
						<td align="center"><b>��й�ȣ�� �Է����ּ���</b></td>
					</tr>
					<tr height="30">
						<td align="center">
						��й�ȣ : <input type="password" name="inputPasswd"> 
						<input type="hidden" name="num" value="<%=num%>">
						</td>
					</tr>
					<tr height="30">
						<td align="center">
						<input type="submit" value="�����ϱ�"> 
						<input type="button" value="�ڷΰ���" onclick="window.history.back()">
						</td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>