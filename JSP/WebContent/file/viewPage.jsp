<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String saveFolder = "C:\\Users\\sist32\\Desktop\\uploadFile";
	String encType = "euc-kr";
	int maxSize = 5*1024*1024;
	
	try {
	MultipartRequest multi = null;
	multi = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());		// DefaultFileRenamePolicy() �����̸��� ������ ��ȣ�ο�
	
	Enumeration params = multi.getParameterNames();
	
	
	while (params.hasMoreElements()) {
		String name = (String)params.nextElement();
		String value = multi.getParameter(name);
		out.println(name + " = " + value + "<br>");
	}
	
	Enumeration files = multi.getFileNames();
	
	while (files.hasMoreElements()) {
		String name = (String)files.nextElement();
		String filename = multi.getFilesystemName(name);
		String original = multi.getOriginalFileName(name);
		String type = multi.getContentType(name);
		
		File f = multi.getFile(name);
		
		out.println("�Ķ���� �̸� : " + name + "<br>");
		out.println("����� ���� �̸� : " + filename + "<br>");
		out.println("���� ���� �̸� : " + original + "<br>");
		out.println("���� Ÿ�� : " + type + "<br>");
		
		if (f != null) {
			out.println("ũ�� : " + f.length() + "����Ʈ");
			out.println("<br>");
		}
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
%>
