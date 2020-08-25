<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<jsp:useBean id="cDao" class="com.semosam.dao.courseDAO" />
<jsp:useBean id="cDto" class="com.semosam.dto.courseDTO" />
<jsp:setProperty property="*" name="cDto"/>

<body>
<%
	int result = cDao.updateCourse(cDto);

	String msg = "수업변경에 실패 하였습니다.";
	String location = "javascript:history.back()";

	if (result == 1) {
		msg = "수업변경에 성공 하였습니다.";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=location%>";
</script>
</body>