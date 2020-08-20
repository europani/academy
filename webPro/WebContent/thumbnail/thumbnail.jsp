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
<title>�����̹����� ����� �̹��� ����</title>
</head>
<body>
<%
	String path = application.getRealPath("/") + "thumbnail/";
	int size = 10 * 1024 * 1024;
	MultipartRequest multi = new MultipartRequest(request, path, size, "EUC-KR");
	
	String fname = multi.getFilesystemName("picture"); // ���ε� ���ϸ�
	
	BufferedImage bi = ImageIO.read(new File(path + fname));	// ���� �̹���
	int width = bi.getWidth() / 5;
	int height = bi.getHeight() / 5;
	
	BufferedImage thumb = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 	// ����� �̹���
	Graphics2D g = thumb.createGraphics();		// �׸��� ����
	g.drawImage(bi, 0, 0, width, height, null);
	File f = new File(path + "sm_" + fname);
	ImageIO.write(thumb, "jpg", f);		// �̹��� ����

%>

<h3>�����̹���</h3>
<img src="<%=fname%>"><p>
<h3>����� �̹���</h3>
<img src="sm_<%=fname%>"><p>
</body>
</html>