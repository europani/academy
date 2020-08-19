<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	String id = (String) session.getAttribute("idKey");
%>

<!DOCTYPE html>

<head>
<meta charset="EUC-KR">
<!-- <meta http-equiv="x-ua-compatible" content="ie=edge">
 -->
<title>����� - ������ ��� ������</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="/JSP_PROJECT/favicon.ico">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/bootstrap.min.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/owl.carousel.min.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/magnific-popup.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/font-awesome.min.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/themify-icons.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/nice-select.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/flaticon.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/gijgo.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/animate.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/slicknav.css">
<link rel="stylesheet" href="/JSP_PROJECT/edumark/css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap"
	rel="stylesheet">

<!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

<!-- header-start -->
<header>
	<div class="header-area ">
		<div id="sticky-header" class="main-header-area">
			<div class="container-fluid p-0">
				<div class="row align-items-center no-gutters">
					<div class="col-xl-2 col-lg-2">
						<div class="logo-img">
							<a href="index.html"> <img src="img/logo.png" alt=""> <!-- �ΰ��̹��� -->
							</a>
						</div>
					</div>
					<div class="col-xl-7 col-lg-7">
						<div class="main-menu  d-none d-lg-block">
							<nav>
								<ul id="navigation">
									<li><a href="/JSP_PROJECT/board/index.jsp">����</a></li>
									<li><a href="/JSP_PROJECT/board/courses.jsp">����</a></li>
									<li><a href="#">������<i class="ti-angle-down"></i></a>
										<ul class="submenu">
											<li><a href="/JSP_PROJECT/board/teacher/teacherSingup.jsp">�ܵ��</a></li>
											<li><a href="#">�������</a></li>
											<li><a href="#">��û�� ��ȸ</a></li>
										</ul></li>
									<li><a href="#">����������<i class="ti-angle-down"></i></a>
										<ul class="submenu">
											<li><a href="#">ȸ������</a></li>
											<li><a href="#">�������</a></li>
											<li><a href="#">����</a></li>
										</ul></li>
									<li><a href="#">������<i class="ti-angle-down"></i></a>
										<ul class="submenu">
											<li><a href="#">��������</a></li>
											<li><a href="#">Q&A</a></li>

										</ul></li>
								</ul>
							</nav>
						</div>
					</div>
					<div class="col-xl-3 col-lg-3 d-none d-lg-block">
						<div class="log_chat_area d-flex align-items-center main-menu">
							<a href="/JSP_PROJECT/board/teacher/teacherSingup.jsp" class="login"> <i
								class="flaticon-user"></i> <span>�ܵ��</span>
							</a>
							<%
								if (id != null) {
							%>
							<a href="/JSP_PROJECT/board/header/logoutProc.jsp" class="boxed_btn_orange"> <!-- <i class="fa fa-phone"></i> -->
								<span>�α׾ƿ�</span>
							</a>
							<%
								} else {
							%>
							<a href="#test-form" class="boxed_btn_orange popup-with-form"> <!-- <i class="fa fa-phone"></i> -->
								<span>�α���</span>
							</a>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<div class="col-12">
					<div class="mobile_menu d-block d-lg-none"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
</header>
<!-- header-end -->


<!-- �α����� -->
<form id="test-form" class="white-popup-block mfp-hide"
	action="/JSP_PROJECT/board/header/loginProc.jsp" method="post">
	<div class="popup_box ">
		<div class="popup_inner">
			<!-- <div class="logo text-center">
				<a href="#"> <img src="img/form-logo.png" alt="">
				</a>
			</div> -->
			<h3>�α���</h3>
			<form action="#">
				<div class="row">
					<div class="col-xl-12 col-md-12">
						<input type="email" placeholder="�̸���" name="email" required>
					</div>
					<div class="col-xl-12 col-md-12">
						<input type="password" placeholder="��й�ȣ" name="pwd" required>
					</div>
					<div class="col-xl-12">
						<button type="submit" class="boxed_btn_orange" form="test-form">�α���</button>
					</div>
				</div>
			</form>
			<p class="doen_have_acc">
				���� ȸ���� �ƴϽʴϱ�? <a class="dont-hav-acc" href="#test-form2">ȸ������</a>
			</p>
		</div>
	</div>
</form>
<!-- form itself end -->

<!-- ȸ������ �� -->
<form id="test-form2" class="white-popup-block mfp-hide"
	action="/JSP_PROJECT/board/header/signupProc.jsp" name="regForm" method="post">
	<div class="popup_box">
		<div class="popup_inner">

			<h3>ȸ������</h3>
			<form action="#">
				<div class="row">
					<div class="col-xl-12 col-md-12">
						<input type="email" name="email" id="email" placeholder="�̸���" required>
					</div>

					<div class="alert alert-success col-xl-12 col-md-12 input" id="alert-success1">��밡����
						�̸����Դϴ�.</div>
					<div class="alert alert-danger col-xl-12 col-md-12" id="alert-danger1">�̸��� ���Ŀ� �°� ���ּ���.</div>

					<div class="col-xl-12 col-md-12">
						<input type="password" name="pwd" id="pwd1" placeholder="��й�ȣ" required>
					</div>
					<div class="col-xl-12 col-md-12">
						<input type="Password" name="repwd" id="pwd2" placeholder="��й�ȣ ��Ȯ��" required>
					</div>
					<div class="alert alert-success col-xl-12 col-md-12" id="alert-success2">��й�ȣ�� ��ġ�մϴ�.</div>
					<div class="alert alert-danger col-xl-12 col-md-12" id="alert-danger2">��й�ȣ�� ��ġ���� �ʽ��ϴ�.</div>
					<div class="col-xl-12 col-md-12">
						<input type="text" name="name" placeholder="����" required>
					</div>
					<div class="col-xl-12 col-md-12">
						<div class="switch-wrap d-flex justify-content-between">
							<p>��</p>
							<div class="primary-radio">
								<input type="radio" name="gender" value="male" id="male" value="1"> <label
									for="male"></label>
							</div>
							<p>��</p>
							<div class="primary-radio">
								<input type="radio" name="gender" value="female" id="female" value="2"><label
									for="female"></label>

							</div>
						</div>
					</div>

					<div class="col-xl-12 col-md-12">
						<input type="text" name="tel" id="tel" placeholder="����ó" size="3" required>
					</div>
				</div>
				<h5>���ɻ�</h5>
				<div class="row">

					<div class="col-xl-12 col-md-12">
						<div class="switch-wrap d-flex justify-content-between">
							<p>������</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="������" value="������"> <label for="������"></label>
							</div>
							<p>�ǹ�����</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="�ǹ�����" value="�ǹ�����"> <label for="�ǹ�����"></label>
							</div>
							<p>��Ƽ</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="��Ƽ" value="��Ƽ"> <label for="��Ƽ"></label>
							</div>
							<p>����</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="����" value="����"> <label for="����"></label>
							</div>
						</div>
						<div class="switch-wrap d-flex justify-content-between">
							<p>�ܱ���</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="�ܱ���" value="�ܱ���"> <label for="�ܱ���"></label>
							</div>
							<p>����</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="����" value="����"> <label for="����"></label>
							</div>
							<p>��������Ÿ��</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="��������Ÿ��" value="��������Ÿ��"> <label for="��������Ÿ��"></label>
							</div>
							<p>��Ÿ</p>
							<div class="primary-checkbox">
								<input type="checkbox" name="interests" id="��Ÿ" value="��Ÿ"> <label for="��Ÿ"></label>
							</div>
						</div>
									
					</div>

					<div class="col-xl-12">
						<button id="submit" type="submit" class="boxed_btn_orange" form="test-form2">ȸ������</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</form>
<!-- form itself end -->


<!-- JS here -->
<script src="/JSP_PROJECT/edumark/js/vendor/modernizr-3.5.0.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/popper.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/bootstrap.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/owl.carousel.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/isotope.pkgd.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/ajax-form.js"></script>
<script src="/JSP_PROJECT/edumark/js/waypoints.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/jquery.counterup.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/imagesloaded.pkgd.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/scrollIt.js"></script>
<script src="/JSP_PROJECT/edumark/js/jquery.scrollUp.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/wow.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/nice-select.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/jquery.slicknav.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/jquery.magnific-popup.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/plugins.js"></script>
<script src="/JSP_PROJECT/edumark/js/gijgo.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/reg.js"></script>
<script src="/JSP_PROJECT/edumark/js/regSubmit.js"></script>

<!--contact js-->
<script src="/JSP_PROJECT/edumark/js/contact.js"></script>
<script src="/JSP_PROJECT/edumark/js/jquery.ajaxchimp.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/jquery.form.js"></script>
<script src="/JSP_PROJECT/edumark/js/jquery.validate.min.js"></script>
<script src="/JSP_PROJECT/edumark/js/mail-script.js"></script>

<script src="/JSP_PROJECT/edumark/js/main.js"></script>