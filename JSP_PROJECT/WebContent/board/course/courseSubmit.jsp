<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style>

td {
	padding-bottom: 20px;
}
</style>

<script type="text/javascript">
<%--
	if(<%=id %> == null) {
		alert('�α����� �ʿ��մϴ�.');
		history.go(-1);
	}
--%>
	function applicant() {
		alert("���� ��û�� �Ϸ�Ǿ����ϴ�.");
		document.applicantForm.submit();
	}
</script>

</head>
<body>

<!-- bradcam_area_start -->
<div class="bradcam_area breadcam_bg overlay2" onclick="applicant()">
	<h3>������û</h3>
</div>
<!-- bradcam_area_end -->

<div class="courses_details_info">
	<div class="container">
		<div class="row">
		
			<div class="col-xl-7 col-lg-7">
				<div class="single_courses" style="margin-bottom: 20px;">
					<h4>������ : </h4>
					<br>
					 <h4 class="second_title"><i class="ti-calendar"></i>&nbsp;&nbsp;���Ͻô� ���������� �������ּ���.</h4>
				</div>
					<div class="outline_courses_info">
					
					<form name="applicantForm" method="post" action="courseSubmitProc.jsp" >
					<table style="margin-top: 30px;
								margin-left:30px;">
						<tr>
						<td>
						<div class="primary-radio" style="float: left">
							<input type="radio" id="schedule1" name="schedule" value="1" checked>
							<label for="schedule1"></label>
							</div>
						</td>
						<td>
						&nbsp;&nbsp;2020�� 8�� 24�� ������ 9:00
						</td>
						</tr>
						<tr>
						<td>
						<div class="primary-radio" style="float: left">
							<input type="radio" id="schedule2" name="schedule" value="2" >
							<label for="schedule2"></label>
						</div>
						</td>
						<td>
						&nbsp;&nbsp;2020�� 8�� 25�� ȭ���� 9:00
						</td>
						</tr><tr>
						<td>
						<div class="primary-radio" style="float: left">
							<input type="radio" id="schedule3" name="schedule" value="3">
							<label for="schedule3"></label>
							</div>
						</td>
						<td>
						&nbsp;&nbsp;2020�� 8�� 26�� ������ 9:00
						</td>
						</tr>
					</table>
											
					</form>
					</div>
				</div>
			
			<div class="col-xl-5 col-lg-5">
				<div class="courses_sidebar" style="margin-top: 10px;">
				
					<!-- �ܼҰ� -->
					<div class="author_info">
						<div class="auhor_header">
							<div class="thumb">
								<img src="/JSP_PROJECT/uploadFile/4.jpg" alt="" height="90" width="90" style="border-radius: 100%;" >
							</div>
							<div class="name">
								<h3>�������� ��</h3>
								<p>�� �̷�?</p>
							</div>
						</div>
						<p class="text_info"><br>������ ���Ű� ȯ���ؿ�!<br><b>���,������,�ð�</b>�� �������ּ���.</p>
						<ul>
							<li><a href="#"> <i class="fa fa-envelope"></i>
							</a></li>
							<li><a href="#"> <i class="fa fa-twitter"></i>
							</a></li>
							<li><a href="#"> <i class="ti-linkedin"></i>
							</a></li>
						</ul>
					</div>
					<a href="/JSP_PROJECT/board/course/courseSubmitProc.jsp" class="boxed_btn">���� ��û�ϱ�</a>
					
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="col-xl-12" style="padding-top: 50px;">
		<div class="more_courses text-center">
			<a href="#" class="boxed_btn_rev">���� ��û�ϱ�</a>
		</div>
	</div> -->
</div>

	
</body>
</html>