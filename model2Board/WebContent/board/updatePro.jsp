<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="board.BoardDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "board.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>
<%	request.setCharacterEncoding("euc-kr");%>
<%	String realFolder = "";
		String saveFolder = "uploadFile";
		String encType = "euc-kr";
		int maxSize = 10 * 1024 * 1024;//10M
		ServletContext context = getServletContext();
		realFolder = context.getRealPath(saveFolder);
		int check=-1;
		try {
			MultipartRequest multi = 
			new MultipartRequest(request, realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
			BoardDTO article = new BoardDTO();
			Enumeration files = multi.getFileNames();
			if (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				File file = multi.getFile(name);
				if (file != null) {
					article.setFilename(file.getName());
					article.setFilesize((int) file.length());				} 
				else {
					article.setFilename(multi.getParameter("oldFile"));
				}
			article.setNum(Integer.parseInt(multi.getParameter("num")));
			article.setWriter(multi.getParameter("writer"));
			article.setContent(multi.getParameter("content"));
			article.setPasswd(multi.getParameter("passwd"));
			article.setSubject(multi.getParameter("subject"));
			article.setEmail(multi.getParameter("email"));
			article.setBoardid((String) session.getAttribute("boardid"));
			article.setIp(request.getRemoteAddr());
			BoardDAO dbPro = BoardDAO.getInstance();
			check=dbPro.updateArticle(article, boardid);			}
		} catch (Exception e) {	e.printStackTrace();}
    if(check==1){%>
<meta http-equiv="Refresh" 
content="0;url=list.jsp" >
<% }else{%>      <script language="JavaScript">      
        alert("비밀번호가 맞지 않습니다");      history.go(-1);    
     </script><%    } %>   