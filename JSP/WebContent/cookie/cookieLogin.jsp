<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	String cookieName = "";
	String id = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("idKey")) {
				cookieName = cookies[i].getName();
				id = cookies[i].getValue();
			}
		}
		if (!id.equals("")) {
	
%>
<script>
	alert("로그인 되었습니다.");
	location.href = "cookieLoginOK.jsp";
</script>
<%
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Cookie 로그인</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<h2 align="center">Cookie 로그인</h2>
	<form method="post" action="cookieLoginProc.jsp">
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