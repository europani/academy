<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	String id =	(String)session.getAttribute("idKey"); 

	if (id != null) {
%>
<script>
	alert("�α��� �Ǿ����ϴ�.");
	location.href = "sessionLoginOK.jsp";
</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Cookie �α���</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<h2 align="center">Cookie �α���</h2>
	<form method="post" action="sessionLoginProc.jsp">
		<table width="300" border="1" align="center" bgcolor="#FF9">
			<tr bordercolor="#FF6">
				<td colspan="2" align="center"><b>Log in</b></td>
			</tr>
			<tr>
				<td width="47%" align="center">ID</td>
				<td width="53" align="center"><input name="id"></td>
			</tr>	
			<tr>
				<td align="center">PWD</td>
				<td align="center"><input name="pwd"></td>
			</tr>	
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="login">
					<input type="reset" name="reset">
				</td>
			</tr>	
		</table>
	</form>
</body>
</html>