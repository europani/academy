<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
<form name="regFrm" method="post" action="memberProc.jsp">
	<table align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td bgcolor="#996600" colspan="3" align="center"><font color="#FFFFFF">ȸ�� ����</font></td>
		</tr>
		<tr>
			<td>���̵�</td>
			<td><input name="id"><input type="button" value="ID�ߺ�Ȯ��" onclick=""></td>
			<td>���̵� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�н�����</td>
			<td><input name="pwd"></td>
			<td>�н����带 ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�н����� Ȯ��</td>
			<td><input name="pwd"></td>
			<td>�н����带 Ȯ���մϴ�.</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><input name="name"></td>
			<td>�̸��� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>����</td>
			<td>��<input type="radio" name="gender" value="��">��<input type="radio" name="gender" value="��"></td>
			<td>������ ���� �ϼ���.</td>
		</tr>
		<tr>
			<td>�������</td>
			<td><input name="birthday" size="5"> ex)830815</td>
			<td>������ ���� �ϼ���.</td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input name="email"></td>
			<td>�̸����� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�����ȣ</td>
			<td><input name="zipcode"><input type="button" value="�����ȣã��" onclick=""></td>
			<td>�����ȣ�� �˻��ϼ���.</td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td><input name="address" size="50"></td>
			<td>�ּҸ� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>���</td>
			<td>
				���ͳ�<input type="checkbox" name="hobby" value="internet">
				����<input type="checkbox" name="hobby" value="travel">
				����<input type="checkbox" name="hobby" value="game">
				��ȭ<input type="checkbox" name="hobby" value="movie">
				�<input type="checkbox" name="hobby" value="exercise">
			</td>
			<td>��̸� �����ϼ���.</td>
		</tr>
		<tr>
			<td>����</td>
			<td>
				<select name="job">
					<option selected>�����ϼ���.</option>
					<option value="ȸ���">ȸ���</option>
					<option value="�л�">�л�</option>
					<option value="������">������</option>
					<option value="IT">IT</option>
					<option value="�Ƿ�">�Ƿ�</option>
					<option value="�ֺ�">�ֺ�</option>
					<option value="����">����</option>
				</select>					
			</td>
			<td>������ �����ϼ���.</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" value="ȸ������" >
				<input type="reset" value="�ٽþ���" onclick="">
				<input type="button" value="�α���" onclick="">
			</td>
		</tr>
	</table>
</form>
</body>
</html>