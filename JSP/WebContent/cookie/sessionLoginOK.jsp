<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String id = (String)session.getAttribute("idKey");
	if (id == null) {
	
%>
<script>
	alert("�α��� ���� �ʾҽ��ϴ�.");
	location.href = "sessionLogin.jsp";
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
				<td align="center"><b><%=id %>���� �α��� �ϼ̽��ϴ�.</b></td>
				<td align="center"><a href="cookieLogout.jsp">�α׾ƿ�</a></td>
			</tr>	
			
		</table>
	</form>
</body>
</html>