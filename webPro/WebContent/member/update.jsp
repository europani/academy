<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<%
	String id = (String)session.getAttribute("idKey");
		
	MemberDAO mgr = new MemberDAO();
	MemberDTO mem = mgr.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 가입</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<form name="updateFrm" method="post" action="updateProc.jsp">
	<table align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td bgcolor="#996600" colspan="3" align="center"><font color="#FFFFFF">회원 정보 수정</font></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="hidden" name="id" value="<%=id%>"><%=id%></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input name="pwd" type="password"></td>
			<td>패스워드를 적어 주세요.</td>
		</tr>
		<tr>
			<td>패스워드 확인</td>
			<td><input name="repwd" type="password"></td>
			<td>패스워드를 확인합니다.</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input name="name" value="<%=mem.getName()%>"></td>
			<td>이름을 적어 주세요.</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				남<input type="radio" name="gender" value="1" <%=mem.getGender().equals("1")? "checked":"" %>>
				여<input type="radio" name="gender" value="2" <%=mem.getGender().equals("2")? "checked":"" %>>
			</td>
			<td>성별을 선택 하세요.</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input name="birthday" size="5" value="<%=mem.getBirthday()%>"> ex)830815</td>
			<td>성별을 선택 하세요.</td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" value="<%=mem.getEmail() %>"></td>
			<td>이메일을 적어 주세요.</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input id="sample4_postcode" name="zipcode" size="5" value="<%=mem.getZipcode()%>"><input type="button" value="우편번호찾기" onclick="sample4_execDaumPostcode()"></td>
			<td>우편번호를 검색하세요.</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input id="sample4_roadAddress" name="address" size="50" value="<%=mem.getAddress()%>"></td>
			<td>주소를 적어 주세요.</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				인터넷<input type="checkbox" name="hobby" value="internet" <%= mem.getNewhobby().contains("internet")? "checked" : "" %>>
				여행<input type="checkbox" name="hobby" value="travel" <%= mem.getNewhobby().contains("travel")? "checked" : "" %>>
				게임<input type="checkbox" name="hobby" value="game" <%= mem.getNewhobby().contains("game")? "checked" : "" %>>
				영화<input type="checkbox" name="hobby" value="movie" <%= mem.getNewhobby().contains("movie")? "checked" : "" %>>
				운동<input type="checkbox" name="hobby" value="exercise" <%= mem.getNewhobby().contains("exercise")? "checked" : "" %>>
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
			<script>
				document.updateFrm.job.value='<%=mem.getJob()%>';		/* JS가 알아서해줌 */
			</script>
			<td>직업을 선택하세요.</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="button" value="정보수정" onclick="inputCheck2()">
				<input type="reset" value="다시쓰기">
				<input type="button" value="뒤로가기" onclick="history.back()">
			</td>
		</tr>
	</table>
</form>
<script src="/webPro/js/javascript.js" type="text/javascript"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
            }
        }).open();
        
    }
</script>
</body>
</html>