<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/jsp/JDBC/insert.jsp">
		<table>
			<tr>
				<td>���̵�</td>
				<td><input name="memberID"></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input name="name"></td>
			</tr>
			<tr>
				<td>�̸���</td>
				<td><input name="email"></td>
			</tr>
			<tr>
				<td><input type="submit" value="�����ϱ�"></td>
			</tr>
		</table>
	</form>
</body>
</html>