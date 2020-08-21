<%@page import="java.awt.Graphics2D"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String path = application.getRealPath("picture");
	String fname = null;
	File f = new File(path);
	if (!f.exists()) {
		f.mkdir();
	}
	MultipartRequest multi = new MultipartRequest(request, path, 10*1024*1024, "EUC-KR");
	fname = multi.getFilesystemName("picture");		// 업로드된 파일명
	System.out.println(path + fname);
	
	// 썸네일 이미지 생성
	BufferedImage bi = ImageIO.read(new File(path + "\\" + fname));
	int width = bi.getWidth()/3;
	int height = bi.getHeight()/3;
	BufferedImage thumb = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
	Graphics2D g = thumb.createGraphics();
	g.drawImage(bi, 0, 0, width, height, null);
	f = new File(path + "sm" + fname);
	ImageIO.write(thumb, "jpg", f);
%>
<script>
	img = opener.document.querySelector("#pic");
	img.src = "<%=request.getContextPath()%>/picture/<%=fname%>";		// opener 창에 이미지파일
	opener.document.regFrm.picture.value = "<%=fname%>";		// hidden 태그 파라미터 지정
	self.close();
</script>