<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="regForm" class="beans.MemberBean" scope="page"></jsp:useBean>
<jsp:setProperty name="regForm" property="*"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� �Ϸ�</title>
<link href="/jsp/bean/style.css">
</head>
<body bgcolor="#996600">
	<table width="500" align="center" cellspacing="0" cellpadding="5">
		<tr>
			<td align="center" valign="middle" bgcolor="#ffffcc">
				<table border="1" cellspacing="0" cellpadding="2" align="center">
					<form name="regForm" method="post" action="memberInsert.jsp">
						<tr align="center" bgcolor="#996600">
							<td colspan="3"><font color="#fff"><b>ȸ�� ���� �Ϸ�</b></font></td>
						</tr>
						<tr>
							<td width="200">���̵�</td>
							<td width="300"><jsp:getProperty name="regForm" property="id" /></td>
						</tr>
						<tr>
							<td>�н�����</td>
							<td width="300"><jsp:getProperty name="regForm" property="pwd" /></td>
						</tr>
						<tr>
							<td>�̸�</td>
							<td width="300"><jsp:getProperty name="regForm" property="name" /></td>	
						</tr>
						<tr>
							<td>�������</td>
							<td width="300"><jsp:getProperty name="regForm" property="birthday" /></td>
						</tr>
						<tr>
							<td>�̸���</td>
							<td width="300"><jsp:getProperty name="regForm" property="email" /></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
							<input type="button" value="Ȯ�οϷ�"> 
							<input type="button" value="�ٽþ���" onclick="history.back()"></td>
						</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>