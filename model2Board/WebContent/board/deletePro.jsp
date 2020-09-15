<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "board.BoardDAO" %>
<%@ page import = "java.sql.Timestamp" %>
<%	request.setCharacterEncoding("euc-kr");%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
  String passwd = request.getParameter("passwd");
  BoardDAO dbPro = BoardDAO.getInstance();
  int check = dbPro.deleteArticle(num, passwd, boardid);
  if(check==1){
%>	  <meta http-equiv="Refresh" 
	  content="0;url=list.jsp" >
<% }else{%>
       <script language="JavaScript">      
         alert("비밀번호가 맞지 않습니다");
         history.go(-1);
       </script><%    } %>