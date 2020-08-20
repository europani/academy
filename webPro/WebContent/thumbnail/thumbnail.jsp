<%@page import="java.awt.Graphics2D"%>
<%@page import="java.io.File"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>원본이미지와 썸네일 이미지 보기</title>
</head>
<body>
<%
	String path = application.getRealPath("/") + "thumbnail/";
	int size = 10 * 1024 * 1024;
	MultipartRequest multi = new MultipartRequest(request, path, size, "EUC-KR");
	
	String fname = multi.getFilesystemName("picture"); // 업로드 파일명
	
	BufferedImage bi = ImageIO.read(new File(path + fname));	// 원본 이미지
	int width = bi.getWidth() / 5;
	int height = bi.getHeight() / 5;
	
	BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 	// 썸네일 이미지
	Graphics2D g = thumb.createGraphics();		// 그리기 도구
	g.drawImage(bi, 0, 0, width, height, null);
	File f = new File(path + "sm_" + fname);
	ImageIO.write(thumb, "jpg", f);		// 이미지 저장

%>

<h3>원본이미지</h3>
<img src="<%=fname%>"><p>
<h3>썸네일 이미지</h3>
<img src="sm_<%=fname%>"><p>
</body>
</html>