<%@page import="com.semosam.dto.courseDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="cDao" class="com.semosam.dao.courseDAO" />
<jsp:useBean id="cDto" class="com.semosam.dto.courseDTO" />
<jsp:setProperty property="*" name="cDto"/>
<%
	int result = cDao.updateCourse(cDto);

	String msg = "�������濡 ���� �Ͽ����ϴ�.";
	String location = "/JSP_PROJECT/board/teacher/courseContent.jsp";

	if (result == 1) {
		msg = "�������濡 ���� �Ͽ����ϴ�.";
	}
%>
<script>
alert("<%=msg%>");
location.href="<%=location%>";
</script>