<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="bean" class="member.MemberBean" />
<jsp:useBean id="mgr" class="member.MemberMgr" />
<jsp:setProperty name="bean" property="*" />
<%
	boolean result = mgr.insertMember(bean);
	String msg = "ȸ�����Կ� ���� �Ͽ����ϴ�.";
	String location = "member.jsp";
	if (result) {
		msg = "ȸ�������� �Ͽ����ϴ�.";
		location = "login.jsp";
	}

%>
<script>
	alert("<%=msg%>");
	location.href="<%=location%>";
</script>
