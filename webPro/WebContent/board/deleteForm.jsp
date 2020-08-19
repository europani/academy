<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String num = request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<p class="w3-left" style="padding-left: 30px;"><%=board%></p>
	<div class="w3-container">
		<b>글삭제<br>
			<form method="post" name="delForm" action="deletePro.jsp">
				<table class="table-bordered" width="360">
					<tr height="30">
						<td align="center"><b>비밀번호를 입력해주세요</b></td>
					</tr>
					<tr height="30">
						<td align="center">
						비밀번호 : <input type="password" name="inputPasswd"> 
						<input type="hidden" name="num" value="<%=num%>">
						</td>
					</tr>
					<tr height="30">
						<td align="center">
						<input type="submit" value="삭제하기"> 
						<input type="button" value="뒤로가기" onclick="window.history.back()">
						</td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>