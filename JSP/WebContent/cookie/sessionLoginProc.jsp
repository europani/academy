<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="regMgr" class="JDBC.RegisterMgr"></jsp:useBean>
<%  
	String id = "";
	String pwd = "";
	
	if(request.getParameter("id") != null) {
		id = request.getParameter("id"); }
	if(request.getParameter("pwd") != null) {
		pwd = request.getParameter("pwd"); }
	if(regMgr.loginRegister(id, pwd)) {
		session.setAttribute("idKey", id);

%>

<script type="text/javascript">
	alert('�α��� �Ǿ����ϴ�.');
	location.href="sessionLoginOK.jsp"
</script>
<% } else { %>
<script type="text/javascript">
	alert('�α��� ���� �ʾҽ��ϴ�..');
	location.href="sessionLogin.jsp"
</script>
<% } %>
