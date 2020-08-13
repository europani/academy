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
	String msg = "정보수정에 실패 하였습니다.";
	String location = "update.jsp";
	if (result != 0) {
		msg = "정보수정에 성공 하였습니다.";
		location = "login.jsp";
	}

%>
<script>
	alert("<%=msg%>");
	location.href="<%=location%>";
</script>