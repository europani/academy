<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="bean" class="member.MemberBean" />
<jsp:useBean id="mgr" class="member.MemberMgr" />
<jsp:setProperty name="bean" property="*" />
<%
	boolean result = mgr.insertMember(bean);
	String msg = "회원가입에 실패 하였습니다.";
	String location = "member.jsp";
	if (result) {
		msg = "회원가입을 하였습니다.";
		location = "login.jsp";
	}

%>
<script>
	alert("<%=msg%>");
	location.href="<%=location%>";
</script>
