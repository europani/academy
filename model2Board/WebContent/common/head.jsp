<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<style>
	a {
		text-decoration: none;
	}
</style>
<script>
  window.onload = function() {
	 var atag = document.getElementsByTagName("a");
	 var url = document.location.href.split("/"); 
	 
	 if (url[url.length-2]=="member"){
		 atag[4].className +=" w3-red"; 
	 }  else if (url[url.length-2]=="chartjsPro"){
		 atag[5].className +=" w3-red"; 
	 }  else if (url[url.length-2]=="awesomePro"){
		 atag[6].className +=" w3-red"; 
	 }  else {
		 atag[${boardid}].className +=" w3-red";
	 }
  }
</script>
<body>
	<div class="w3-bar w3-large"
		style="background: #7ed6df; color: #FFFFFF">
		<a href="<%=request.getContextPath()%>/member/main.do" class="w3-bar-item w3-button">HOME</a> 
		<a href="<%=request.getContextPath()%>/list.do?boardid=1" class="w3-bar-item w3-button">��������</a> 
		<a href="<%=request.getContextPath()%>/list.do?boardid=2" class="w3-bar-item w3-button">�����Խ���</a> 
		<a href="<%=request.getContextPath()%>/list.do?boardid=3" class="w3-bar-item w3-button">Q&A</a> 
		<a href="<%=request.getContextPath()%>/chart/bar_sample.do" class="w3-bar-item w3-button">BarGraph</a> 
		<a href="<%=request.getContextPath()%>/cloud/awesomeCloud.do" class="w3-bar-item w3-button">WordCloud</a> 
		<a href="<%=request.getContextPath()%>/websocket/websocket01.do" class="w3-bar-item w3-button">ä��</a>

		<c:if test="${idKey == null}">
			<a href="<%=request.getContextPath()%>/member/member.do" class="w3-bar-item w3-button">ȸ������</a> 
			<a href="<%=request.getContextPath()%>/member/login.do" class="w3-bar-item w3-button">�α���</a>
		</c:if>	
		<c:if test="${idKey != null}">
			<a href="<%=request.getContextPath()%>/member/update.do" class="w3-bar-item w3-button">ȸ������</a> 
			<a href="<%=request.getContextPath()%>/member/logout.do" class="w3-bar-item w3-button">�α׾ƿ�</a>
		</c:if>	
	</div>