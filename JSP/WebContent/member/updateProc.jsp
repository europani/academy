<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<jsp:useBean id="mgr" class="member.MemberMgr"/>
<jsp:useBean id="bean" class="member.MemberBean"/>
<jsp:setProperty name="bean" property="*"/>
<%
	int result = mgr.updateMember(bean);
	String msg = "���������� ���� �Ͽ����ϴ�.";
	String location = "update.jsp";
	if (result != 0) {
		msg = "���������� ���� �Ͽ����ϴ�.";
		location = "login.jsp";
	}

%>
<script>
	alert("<%=msg%>");
	location.href="<%=location%>";
</script>