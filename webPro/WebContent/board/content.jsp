<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	try {
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardDTO article = dbPro.getArticle(num, boardid);
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
%>	
<body>
<br><br><b>�۳��� ����</b>
<div class="container">
<table class="w3-table-all" style="width:80%;">
	<tr height="30">
		<td width="125" align="center">�۹�ȣ</td>
		<td width="125" align="center"><%=article.getNum()%></td>
		<td width="125">��ȸ��</td>
		<td width="125" align="center"><%=article.getReadcount()%></td>
	</tr>
	<tr height="30">
		<td width="125">�ۼ���</td>
		<td width="125" align="center"><%=article.getWriter()%></td>
		<td width="125" align="center">�ۼ���</td>
		<td width="125" align="center"><%=article.getReg_date()%></td>
	</tr>
	<tr height="30">
		<td width="125" align="center">������</td>
		<td width="375" align="center" colspan="3"><%=article.getSubject()%></td>
	</tr>
	<tr height="30">
		<td width="125" align="center">�۳���</td>
		<td width="125" align="left" colspan="3"><pre><%=article.getContent()%></pre>
		<img src="/model1Board/uploadFile/<%=article.getFilename()%>">
		</td>
	</tr>
	<tr height="30">
		<td colspan="4" class="w3-center">
			<input type="button" value="�ۼ���" onclick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>'">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="�ۻ���" onclick="document.location.href='deleteForm.jsp?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="�۸��" onclick="document.location.href='list.jsp'">
		</td>
	</tr>
</table>
<%
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
</div>
</body>
</html>