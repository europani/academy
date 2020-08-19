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
<%
	request.setCharacterEncoding("EUC-KR");
	String email = (String) session.getAttribute("idKey");

	String realFolder = "";
	String saveFoleder = "uploadFile";
	String encType = "EUC-KR";
	int maxSize = 10 * 1024 * 1024;

	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFoleder);
%>
<%
	MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
			new DefaultFileRenamePolicy());
	teacherDTO dtoT = new teacherDTO();
	Enumeration files = multi.getFileNames();

	// 업로드한 파일들의 이름을 얻어옴

	String file = (String) files.nextElement();
	File teacherImage = multi.getFile(file);
	dtoT.setTeacherimage(teacherImage.getName());

	dtoT.setTeacherinfo(multi.getParameter("teacherInfo"));
	teacherDAO daoT = new teacherDAO();
	boolean resultT = daoT.insertTeacher(dtoT, email);
%>

<%
	courseDTO dtoC = new courseDTO();

	String file2 = (String) files.nextElement();
	File courseImage = multi.getFile(file2);
	dtoC.setCourseimage(courseImage.getName());
	dtoC.setTitle(multi.getParameter("title"));
	dtoC.setCategory(multi.getParameter("category"));
	dtoC.setDifficulty(multi.getParameter("difficulty"));
	dtoC.setMaxppl(Integer.parseInt(multi.getParameter("maxppl")));
	dtoC.setAddress(multi.getParameter("address"));
	dtoC.setContent(multi.getParameter("content"));
	dtoC.setNotice(multi.getParameter("notice"));
	courseDAO daoC = new courseDAO();
	boolean resultC = daoC.insertCourse(dtoC, email);
%>

<body>
	<%
		String msg = "쌤등록에 실패 하였습니다.";
		String location = "document.referrer";
		if (resultT && resultC) {
			msg = "쌤등록을 하였습니다.";
		}
	%>
	<script type="text/javascript">
	alert("<%=msg%>");
		location.href =	<%=location%>;
	</script>
</body>
</html>