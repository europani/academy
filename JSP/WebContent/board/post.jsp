<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
	<div align="center"><br><br>
		<table>
			<tr>
				<td bgcolor="#84F399" height="25" align="center">�۾���</td>
			</tr>
		</table>
		<br>
		<form name="postFrm" method="post" action="/jsp/board/boardPost" enctype="multipart/form-data">
		<table width="600" cellpadding="3" align="center">
			<tr>
				<td align="center">
				<table align="center">
					<tr>
						<td width="10%">�� ��</td>
						<td width="90%">
							<input name="name" size="10" maxlength="8">
						</td>
					</tr>
					<tr>
						<td>�� ��</td>
						<td>
							<input name="subject" size="50" maxlength="30">
						</td>
					</tr>
					<tr>
						<td>�� ��</td>
						<td>
							<textarea name="content" cols="50" rows="10"></textarea>
						</td>
					</tr>
					<tr>
						<td>��� ��ȣ</td>
						<td>
							<input type="password" name="pass" size="15" maxlength="15">
						</td>
					</tr>
					<tr>
						<td>���� ã��</td>
						<td>
							<input type="file" name="filename" size="50" maxlength="50">
						</td>
					</tr>
					<tr>
						<td>���� Ÿ��</td>
						<td>  
							HTML <input type="radio" name="contentType" value="HTTP">&nbsp;&nbsp;&nbsp;
							TEXT <input type="radio" name="contentType" value="TEXT" checked>
						</td>
					</tr>
					<tr>
						<td colspan="2"><hr></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="���">&nbsp;&nbsp;
							<input type="reset" value="�ٽþ���">&nbsp;
							<input type="button" value="����Ʈ" onclick="javascript:location.href='list.jsp'">
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>">
		</form>
	</div>
</body>
</html>