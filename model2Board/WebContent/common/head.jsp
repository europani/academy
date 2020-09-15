<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<!DOCTYPE html>

<html lang="en"> 
<head>
  <title>Bootstrap Case</title>
  <meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"></head>
<style>a { text-decoration: none; }</style>
<% 
	String board = "";
	
	if (request.getParameter("pageNum") != null) {	// 게시판 내 페이지 이동
		session.setAttribute("pageNum", request.getParameter("pageNum"));
	}
	if (request.getParameter("boardid") != null) {	// 게시판 이동
		session.setAttribute("boardid", request.getParameter("boardid"));
		session.setAttribute("pageNum", "1");
	}

	String pageNum = (String)session.getAttribute("pageNum");		// 세션에 저장
	if (pageNum == null) pageNum = "1";
	
	String boardid = (String)session.getAttribute("boardid");		// 세션에 저장
	if (boardid == null) boardid = "1";
	
	if (boardid.equals("1")) board = "공지사항";
	else if (boardid.equals("2")) board = "자유게시판";
	else if (boardid.equals("3")) board = "Q&A";
	else board = "회원입력";

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
<div class="w3-bar w3-large" style="background:#7ed6df; color: #FFFFFF">
  <a href="<%=request.getContextPath()%>/member/main.jsp"                  class="w3-bar-item w3-button">HOME</a>
  <a href="<%=request.getContextPath()%>/board/list.jsp?boardid=1" class="w3-bar-item w3-button">공지사항</a>
  <a href="<%=request.getContextPath()%>/board/list.jsp?boardid=2" class="w3-bar-item w3-button">자유게시판</a>
  <a href="<%=request.getContextPath()%>/board/list.jsp?boardid=3" class="w3-bar-item w3-button">Q&A</a>
  <a href="<%=request.getContextPath()%>/chart/bar_sample.jsp"    class="w3-bar-item w3-button">BarGraph</a>
  <a href="<%=request.getContextPath()%>/cloud/awesomeCloud.jsp"    class="w3-bar-item w3-button">WordCloud</a>
  <a href="<%=request.getContextPath()%>/websocket/websocket01.jsp"    class="w3-bar-item w3-button">채팅</a>
  
<% 
  	if (session.getAttribute("idKey") == null) {
%> 		
  	  <a href="<%=request.getContextPath()%>/member/member.jsp"    class="w3-bar-item w3-button">회원가입</a>
  	  <a href="<%=request.getContextPath()%>/member/login.jsp"    class="w3-bar-item w3-button">로그인</a>
<%
  	} else {
%>
	  <a href="<%=request.getContextPath()%>/member/update.jsp"    class="w3-bar-item w3-button">회원수정</a>
  	  <a href="<%=request.getContextPath()%>/member/logout.jsp"    class="w3-bar-item w3-button">로그아웃</a>
<%  		
  	}
%>
  

</div>






