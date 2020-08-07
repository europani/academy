<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

	ServletContext context = getServletContext();
	String saveFolder = context.getRealPath("/") + "upload";
	String encType = "EUC-KR";
	int maxSize = 5*1024*1024;
	
	ArrayList saveFiles = new ArrayList();		// 저장된 이름
	ArrayList origFiles = new ArrayList();		// 원래 이름
	
	String user = "";
	String title = "";
	String content = "";
	
	try {
		MultipartRequest multi = null;
		multi = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());		// DefaultFileRenamePolicy() 파일이름이 같으면 번호부여
	
		user = multi.getParameter("user");
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		
		Enumeration files = multi.getFileNames();
		while (files.hasMoreElements()) {
			String name = (String)files.nextElement();
			saveFiles.add(multi.getFilesystemName(name));
			origFiles.add(multi.getOriginalFileName(name));
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="75%" border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#660000" bgcolor="FFFF99">
		<tr bgcolor="#FFCC00">
			<td width="10%"><div align="right"><strong>user</strong></div></td>
			<td width="30%"><%=user %></div></td>
			<td width="10%"><div align="right"><strong>title</strong></div></td>
			<td width="30%"><%=title %></div></td>
		</tr>
		<tr bgcolor="#FFCC00">
			<td width="10%"><div align="right"><strong>content</strong></div></td>
			<td width="50%" colspan="3"><textarea name="content" cols="50" rows="10" disabled> <%=content%></textarea></td>
		</tr>
		<tr bgcolor="#FFCC00">
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr bgcolor="#FFCC00">
			<td colspan="4"><strong>업로드된 파일입니다.</strong></td>
		</tr>
		<% for (int i=0; i < saveFiles.size(); i++) { %>
			<tr bgcolor="#FFCC00">
				<td colspan="4">
				<a href='<%="/jsp/upload/"+saveFiles.get(i) %>'><strong><%=origFiles.get(i) %></strong></a>
				</td>
			</tr>
		<%	} %>
	</table>
</body>
</html>
<%
	} catch (IOException ioe) {
		System.out.println(ioe);
	} catch (Exception e) {
		System.out.println(e);
	}
%>