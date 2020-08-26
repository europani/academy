<%@page import="com.semosam.dto.courseDTO"%>
<%@page import="com.semosam.dao.courseDAO"%>
<%@page import="java.io.File"%>
<%@page import="com.semosam.dto.teacherDTO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.semosam.dao.teacherDAO"%>
<%@page import="com.semosam.dao.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<body>
	<%
		/* String msg = "수업 신청에 실패 하였습니다."; */
		String msg = "수업 신청되었습니다.";
		String location = "document.referrer";
	%>
	<script type="text/javascript">
		alert("<%=msg%>");
		location.href =	<%=location%>;
	</script>
</body>
</html>