<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<title>�Խ���</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br><br>
	<b>�۳��� ����</b>
	<div class="container">
		<table class="w3-table-all" style="width: 80%;">
			<tr height="30">
				<td width="125" align="center">�۹�ȣ</td>
				<td width="125" align="center">${article.num}</td>
				<td width="125">��ȸ��</td>
				<td width="125" align="center">${article.readcount}</td>
			</tr>
			<tr height="30">
				<td width="125">�ۼ���</td>
				<td width="125" align="center">${article.writer}</td>
				<td width="125" align="center">�ۼ���</td>
				<td align="center" width="125" align="center">${article.reg_date}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125">������</td>
				<td align="center" width="375" colspan="3">${article.subject}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125">�۳���</td>
				<td align="left" width="375" colspan="3"><pre>${article.content}</pre>
					<img src="<%=request.getContextPath()%>/uploadFile/${article.filename}"></td>
			</tr>
			<tr height="30">
				<td colspan="4" class="w3-center"><input type="button"
					value="�ۼ���"
					onclick="document.location.href='updateForm.do?num=${article.num}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="�ۻ���" onclick="document.location.href='deleteForm.do?num=${article.num}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="��۾���" onclick="document.location.href='writeUploadForm.do?num=${article.num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="�۸��" onclick="document.location.href='list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

