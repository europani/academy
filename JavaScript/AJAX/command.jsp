<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<% 
request.setCharacterEncoding("utf-8");
String keyword = request.getParameter("keyword");
String[] keywords = {"AJAX", "AJAX실전프로그래밍", "자바프로그래밍", "자바서버페이지", "자바스터디"};

keyword = keyword.replaceAll(" ", "");

String line = "<div>";

for (int i = 0 ; i < keywords.length; i++) {
	if (keywords[i].contains(keyword)) {
		line +="<a href='" + keywords[i] + ".jsp'>" + keywords[i] + "<br>";
	}
}
line += "</div>";

%>
<%= line %>