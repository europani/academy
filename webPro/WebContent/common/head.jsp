<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<html lang="en"> 
<head>
  <title>Bootstrap Case</title>
  <meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"></head>
<style>a { text-decoration: none; }</style>
<% 
  String board = "공지사항";
  String boardid = "1";
  String pageNum = "1";
 %>
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
	 atag[<%=boardid%>].className +=" w3-red";
 }
  }
</script>

<body>
<div class="w3-bar w3-green  w3-large">
  <a href="<%=request.getContextPath()%>/member/main.jsp"                  class="w3-bar-item w3-button">HOME</a>
  <a href="<%=request.getContextPath()%>/board/list.jsp?boardid=1" class="w3-bar-item w3-button">공지사항</a>
  <a href="<%=request.getContextPath()%>/board/list.jsp?boardid=2" class="w3-bar-item w3-button">자유게시판</a>
  <a href="<%=request.getContextPath()%>/board/list.jsp?boardid=3" class="w3-bar-item w3-button">Q&A</a>
  <a href="<%=request.getContextPath()%>/member/inputForm.jsp"    class="w3-bar-item w3-button">회원가입</a>
  <a href="<%=request.getContextPath()%>/chartjsPro/bar_sample.jsp"    class="w3-bar-item w3-button">BarGraph</a>
  <a href="<%=request.getContextPath()%>/awesomePro/aweSomeCloud.jsp"    class="w3-bar-item w3-button">WordCloud</a>
</div>






