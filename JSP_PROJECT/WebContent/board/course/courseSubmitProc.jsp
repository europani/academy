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
		/* String msg = "���� ��û�� ���� �Ͽ����ϴ�."; */
		String msg = "���� ��û�Ǿ����ϴ�.";
		String location = "document.referrer";
	%>
	<script type="text/javascript">
		alert("<%=msg%>");
		location.href =	<%=location%>;
	</script>
</body>
</html>