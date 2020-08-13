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
<title>로그인</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
	<div align="center"><br><br>
		<% if (id != null) {
		%>
			<%=id %>님 환영합니다.
			<p>제한된 기능을 사용 할 수 있습니다.</p>
			<input type="button" value="회원수정" onclick="location.href = 'update.jsp'">
			<input type="button" value="회원탈퇴" onclick="location.href = 'deleteProc.jsp'">
			<input type="button" value="회원리스트" onclick="location.href = 'list.jsp'"><p>
			<a href="logout.jsp">로그아웃</a>
		<%
		} else {
		%>
			<h2>로그인</h2>
			<form name="loginFrm" method="post" action="loginProc.jsp">
				<table>
					<tr>
						<td>아이디</td>
						<td><input name="id"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td colspan="2">
							<div align="center">
								<input type="button" value="로그인" onclick="loginCheck()">&nbsp;
								<input type="button" value="회원가입" onclick="javascript:location.href='member.jsp'">
							</div>
						</td>
				</table>
			</form>
		<%} %>
	</div>


<script type="text/javascript">
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert('아이디를 입력해주세요.');
			document.loginFrm.id.focus();
			return;
		} if (document.loginFrm.pwd.value == "") {
			alert('비밀번호를 입력해주세요.');
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.submit();
	}

</script>
</body>
</html>