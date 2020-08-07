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
<title>회원 가입 완료</title>
<link href="/jsp/bean/style.css">
</head>
<body bgcolor="#996600">
	<table width="500" align="center" cellspacing="0" cellpadding="5">
		<tr>
			<td align="center" valign="middle" bgcolor="#ffffcc">
				<table border="1" cellspacing="0" cellpadding="2" align="center">
					<form name="regForm" method="post" action="memberInsert.jsp">
						<tr align="center" bgcolor="#996600">
							<td colspan="3"><font color="#fff"><b>회원 가입 완료</b></font></td>
						</tr>
						<tr>
							<td width="200">아이디</td>
							<td width="300"><jsp:getProperty name="regForm" property="id" /></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td width="300"><jsp:getProperty name="regForm" property="pwd" /></td>
						</tr>
						<tr>
							<td>이름</td>
							<td width="300"><jsp:getProperty name="regForm" property="name" /></td>	
						</tr>
						<tr>
							<td>생년월일</td>
							<td width="300"><jsp:getProperty name="regForm" property="birthday" /></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td width="300"><jsp:getProperty name="regForm" property="email" /></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
							<input type="button" value="확인완료"> 
							<input type="button" value="다시쓰기" onclick="history.back()"></td>
						</tr>
					</form>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>