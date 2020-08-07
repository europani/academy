<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String serverInfo = application.getServerInfo();
	String mimeType = application.getMimeType("request1.html");
	String realPath = application.getRealPath("/");
	application.log("log 테스트");
%>    
    
<h1>Application Example1</h1>
<p/>서블릿 컨테이너의 이름과 버전 : <%= serverInfo %>
<p/>request1.html의 MIME 타입 : <%= mimeType %>
<p/>로컬 파일 시스템경로 : <%= realPath %>