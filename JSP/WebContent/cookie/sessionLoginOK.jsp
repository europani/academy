<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String id = (String)session.getAttribute("idKey");
	if (id == null) {
	
%>
<script>
	alert("로그인 되지 않았습니다.");
	location.href = "sessionLogin.jsp";
</script>
<%
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
	<form method="post" action="sessionLoginProc.jsp">
		<table width="300" border="1" align="center" bgcolor="#FF9">
			<tr bordercolor="#FF6">
				<td colspan="2" align="center"><b>Log in</b></td>
			</tr>
			<tr>
				<td align="center"><b><%=id %>님이 로그인 하셨습니다.</b></td>
				<td align="center"><a href="cookieLogout.jsp">로그아웃</a></td>
			</tr>	
			
		</table>
	</form>
</body>
</html>