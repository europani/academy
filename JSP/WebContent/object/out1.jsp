<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" buffer="5kb"%>
<%
	int totalBuffer = out.getBufferSize();
	int remainBuffer = out.getRemaining();
	int useBuffer = totalBuffer - remainBuffer;

%>
<h1>Out Example1</h1>
<b>���� �������� Buffer ����</b><p>
��� Buffer�� ��ü ũ�� : <%=totalBuffer %>Byte<p>
���� Buffer�� ũ�� : <%=remainBuffer %>Byte<p>
���� Buffer�� ��뷮 : <%=useBuffer %>Byte<p>
