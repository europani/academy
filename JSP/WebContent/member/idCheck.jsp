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
<title>ID �ߺ� üũ</title>
</head>
<body bgcolor="#FFFFCC">
	<div align="center"><br>
		<b><%=id %></b>
	<%
		if (result) {
			out.println("�� �̹� �����ϴ� ID�Դϴ�.<p>");
		} else {
			out.println("�� ��� ������ ID�Դϴ�.<p>");
		}
	
	%>
		<a href="#" onclick="idCheckOr(<%=result%>)">�ݱ�</a>
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