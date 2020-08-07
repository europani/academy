<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>절대경로를 사용하여 자원 읽기</title>
</head>
<body>
<%
	String resourcePath = "/getpost/notice.txt";

%>
<%= application.getRealPath(resourcePath) %><br>

<%
	char[] buff = new char[128];
	int len = -1;
	
	String filePath = "C:\\Users\\sist32\\eclipse\\jsp\\WebContent\\getpost\\notice2.txt";
	try(InputStreamReader fr = new InputStreamReader(
			/* new FileInputStream(filePath) */
			application.getResourceAsStream(resourcePath), "utf-8")) {
		while ((len = fr.read(buff)) != -1) {
			out.print(new String(buff, 0, len));
		}
	} catch(IOException e) {
		out.println("exception : " + e.getMessage());
	}

%>
</body>
</html>