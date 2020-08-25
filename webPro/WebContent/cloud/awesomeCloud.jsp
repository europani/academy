<%@page import="java.util.Set"%>
<%@page import="cloud.WordCloud"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta charset="utf-8">
<title>jsoup awesomeCloud Plugin Demos</title>
<meta name="description" content="A Word Cloud plugin for jQuery.">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js">
	</script>
<script src="jquery.awesomeCloud-0.2.js"></script>
<style type="text/css">
.wordcloud {   
	border: 1px solid #036;
	height: 7in;
	margin: 0.5in auto;
	padding: 0;
	page-break-after: always;
	page-break-inside: avoid;
	width: 7in;
}
</style>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<%
	String url = null;
	String selector = null;
	
	if (request.getParameter("url") != null && !request.getParameter("url").equals("")) {
		url = request.getParameter("url");
		selector = request.getParameter("selector");
	}
	int viewsize = 3;
	
	if (request.getParameter("viewsize")!=null) {
		viewsize = Integer.parseInt(request.getParameter("viewsize"));
	}
	if (url == null) {
		url = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=421&aid=0004831707";
	}
	if (selector == null) { 		selector = "div[class=_article_body_contents]"; }
		Map<String, Long> map = WordCloud.map(url, selector, 30);
		Set<Map.Entry<String, Long>> set = map.entrySet();
		int cnt = set.size();
		long max = 0;
		
		for (Map.Entry<String, Long> m : set) {
			if (m.getValue() > max) {
				max = m.getValue();
			}
		}
%>
<body>
<br>
<div class="w3-container">
	<form name="f" class="w3-container w3-border" style="width: 70%;" method="post">
		<label>URL : 분석하고 싶은 url을 입력하세요.</label>
		<input class="w3-input" name="url" value="<%=url%>">
		<label>선택자 : 아래 내용은 naver의 선택내용 입니다.</label>
		<input class="w3-input w3-grey" name="selector" value="<%=selector%>">
		<input class="w3-input w3-grey" name="viewsize" value="<%=viewsize%>">
		<input class="w3-input" type="submit" value="wordCloud 출력하기">
	</form>
</div>
<div id="wordcloud1" class="wordcloud">
<%
	for (Map.Entry<String, Long> m : set) {
		cnt--;
		if (m.getValue() > 1) {
%>
		<span data-weight="<%=m.getValue()*(viewsize) %>"><%=m.getKey()%></span>
<%
		}
	}
%>

</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#wordcloud1").awesomeCloud({
			"size" : {"gird" : 9, "factor" : 1},
			"options" : {"color" : "random-dark", "rotationRatio" : 0.35},
			"font" : "'Time New Roman', Times, serif",
			"shape" : "circle"
		});
	});

</script>
<script type="text/javascript">
	let _gaq = _gaq || [];
	_gaq.push([ '_setAccount', "UA-36251023-1"]);
	_gaq.push([ '_setDomainName', "jqueryscript.net"]);
	_gaq.push([ '_trackPageview']);
	( function () {
		let ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'https://www')
		 + '.google-analytics.com/ga.js';
		let s = document.querySelector('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();

</script>
</body>
</html>
