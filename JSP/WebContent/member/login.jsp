<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	String id = (String)session.getAttribute("idKey"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α���</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
	<div align="center"><br><br>
		<% if (id != null) {
		%>
			<%=id %>�� ȯ���մϴ�.
			<p>���ѵ� ����� ��� �� �� �ֽ��ϴ�.</p>
			<input type="button" value="ȸ������" onclick="location.href = 'update.jsp'">
			<input type="button" value="ȸ��Ż��" onclick="location.href = 'deleteProc.jsp'">
			<input type="button" value="ȸ������Ʈ" onclick="location.href = 'list.jsp'"><p>
			<a href="logout.jsp">�α׾ƿ�</a>
		<%
		} else {
		%>
			<h2>�α���</h2>
			<form name="loginFrm" method="post" action="loginProc.jsp">
				<table>
					<tr>
						<td>���̵�</td>
						<td><input name="id"></td>
					</tr>
					<tr>
						<td>��й�ȣ</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td colspan="2">
							<div align="center">
								<input type="button" value="�α���" onclick="loginCheck()">&nbsp;
								<input type="button" value="ȸ������" onclick="javascript:location.href='member.jsp'">
							</div>
						</td>
				</table>
			</form>
		<%} %>
	</div>


<script type="text/javascript">
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert('���̵� �Է����ּ���.');
			document.loginFrm.id.focus();
			return;
		} if (document.loginFrm.pwd.value == "") {
			alert('��й�ȣ�� �Է����ּ���.');
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.submit();
	}

</script>
</body>
</html>