<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
<form name="regFrm" method="post" action="memberProc.jsp">
	<table align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td bgcolor="#996600" colspan="3" align="center"><font color="#FFFFFF">회원 가입</font></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input name="id"><input type="button" value="ID중복확인" onclick=""></td>
			<td>아이디를 적어 주세요.</td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input name="pwd"></td>
			<td>패스워드를 적어 주세요.</td>
		</tr>
		<tr>
			<td>패스워드 확인</td>
			<td><input name="pwd"></td>
			<td>패스워드를 확인합니다.</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input name="name"></td>
			<td>이름을 적어 주세요.</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>남<input type="radio" name="gender" value="남">여<input type="radio" name="gender" value="여"></td>
			<td>성별을 선택 하세요.</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input name="birthday" size="5"> ex)830815</td>
			<td>성별을 선택 하세요.</td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input name="email"></td>
			<td>이메일을 적어 주세요.</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input name="zipcode"><input type="button" value="우편번호찾기" onclick=""></td>
			<td>우편번호를 검색하세요.</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input name="address" size="50"></td>
			<td>주소를 적어 주세요.</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				인터넷<input type="checkbox" name="hobby" value="internet">
				여행<input type="checkbox" name="hobby" value="travel">
				게임<input type="checkbox" name="hobby" value="game">
				영화<input type="checkbox" name="hobby" value="movie">
				운동<input type="checkbox" name="hobby" value="exercise">
			</td>
			<td>취미를 선택하세요.</td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<select name="job">
					<option selected>선택하세요.</option>
					<option value="회사원">회사원</option>
					<option value="학생">학생</option>
					<option value="공무원">공무원</option>
					<option value="IT">IT</option>
					<option value="의료">의료</option>
					<option value="주부">주부</option>
					<option value="무직">무직</option>
				</select>					
			</td>
			<td>직업을 선택하세요.</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" value="회원가입" >
				<input type="reset" value="다시쓰기" onclick="">
				<input type="button" value="로그인" onclick="">
			</td>
		</tr>
	</table>
</form>
</body>
</html>