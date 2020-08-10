<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="mMgr" class="member.MemberMgr" />
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	boolean result = mMgr.checkID(id);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ID 중복 체크</title>
</head>
<body bgcolor="#FFFFCC">
	<div align="center"><br>
		<b><%=id %></b>
	<%
		if (result) {
			out.println("는 이미 존재하는 ID입니다.<p>");
		} else {
			out.println("는 사용 가능한 ID입니다.<p>");
		}
	
	%>
		<a href="#" onclick="idCheckOr(<%=result%>)">닫기</a>
	</div>
<script type="text/javascript">
	 function idCheckOr(chk) {
		if (!chk) {
			opener.document.regFrm.idCheckOk.value = 'yes';
		} else {
			opener.document.regFrm.idCheckOk.value = 'no';
			opener.document.regFrm.id.value = '';
		}
		self.close();
	}


</script>
</body>
</html>