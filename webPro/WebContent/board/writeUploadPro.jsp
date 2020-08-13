<%@page import="board.BoardDAO"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="board.BoardDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String realFolder = "";
	String saveFolder = "uploadFile";	
	String encType = "EUC-KR";
	int maxSize = 10*1024*1024;	//10mb
	ServletContext context = getServletContext();
	realFolder = context.getRealPath(saveFolder);
	
	try {
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		BoardDTO article = new BoardDTO();
		Enumeration files =  multi.getFileNames();
		if (files.hasMoreElements()) {
			String name = (String)files.nextElement();
			File file = multi.getFile(name);
			if (file != null) {
				article.setFilename(file.getName());
				article.setFilesize((int)file.length());
			} else {
				article.setFilename("");
				article.setFilesize(0);
			}
		}
		
			article.setNum(Integer.parseInt(multi.getParameter("num")));
			article.setRef(Integer.parseInt(multi.getParameter("ref")));
			article.setRe_step(Integer.parseInt(multi.getParameter("re_step")));
			article.setRe_level(Integer.parseInt(multi.getParameter("re_level")));
			article.setWriter(multi.getParameter("writer"));
			article.setContent(multi.getParameter("content"));
			article.setPasswd(multi.getParameter("passwd"));
			article.setSubject(multi.getParameter("subject"));
			article.setEmail(multi.getParameter("email"));
			article.setBoardid((String)session.getAttribute("boardid"));
			article.setIp(request.getRemoteAddr());
			BoardDAO dao = BoardDAO.getInstance();
			dao.insertArticle(article, boardid);
	} catch (Exception e) {
		e.printStackTrace();
	}

%>
<meta http-equiv="Refresh" content="0;url=list.jsp">
</body>
</html>