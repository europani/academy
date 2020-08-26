<%@page import="com.semosam.dto.courseDTO"%>
<%@page import="com.semosam.dao.courseDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	int coursenum = Integer.parseInt(request.getParameter("coursenum"));
	courseDAO cDao = new courseDAO();
	courseDTO course = cDao.getCourse(coursenum);
%>
<!DOCTYPE html>
<!-- bradcam_area_start -->
<div class="courses_details_banner">
	<div class="container">
		<div class="row">
			<div class="col-xl-6">
				<div class="course_text">
					<h3>
						<%=course.getTitle() %>
					</h3>
					<div class="prise">
						<span class="active"><%=course.getCategory() %></span>
					</div>
					<div class="rating">
						<i class="flaticon-mark-as-favorite-star"></i> <i class="flaticon-mark-as-favorite-star"></i>
						<i class="flaticon-mark-as-favorite-star"></i> <i class="flaticon-mark-as-favorite-star"></i>
						<i class="flaticon-mark-as-favorite-star"></i> <span>(4.5)</span>
					</div>
					<div class="hours">
						<div class="video">
							<div class="single_video">
								<i class="ti-calendar"></i> <span>���� ���� ����</span>
							</div>
							<div class="single_video">
								<i class="fa fa-clock-o"></i> <span>���� ���� �ð�</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- bradcam_area_end -->

<div class="courses_details_info">
	<div class="container">
		<div class="row">
		
			<div class="col-xl-7 col-lg-7">
				<div class="single_courses">
					<h3><%=course.getTitle() %></h3>
					<p><%=course.getContent() %></p>
					<h3 class="second_title">���� �ȳ�����</h3>
				</div>
				<div class="outline_courses_info">
					<div id="accordion">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne"
										aria-expanded="false" aria-controls="collapseOne">
										<i class="flaticon-question"></i> ���� ���� ����
									</button>
								</h5>
							</div>
							<div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
								<div class="card-body"><%=course.getNotice() %></div>
							</div>
						</div>
						
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo">
										<i class="flaticon-question"></i> ���� ���� �ο�
									</button>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
								<div class="card-body">������ �ִ� <%=course.getMaxppl() %>������ ����˴ϴ�.</div>
							</div>
						</div>
						
						<div class="card">
							<div class="card-header" id="headingThree">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">
										<i class="flaticon-question"></i> ���� ���
									</button>
								</h5>
							</div>
							<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
								<div class="card-body">�ּ�<p><%=course.getAddress() %></p></div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
			
			<div class="col-xl-5 col-lg-5">
				<div class="courses_sidebar">
					<div class="video_thumb">
						<img src="<%=request.getContextPath() %>/uploadFile/<%=course.getCourseimage() %>" alt="">
					</div>
					<div class="author_info" style="margin-top: 100px;">
						<div class="auhor_header">
							<div class="thumb">
								<img src="<%=request.getContextPath() %>/uploadFile/<%=course.getTeacherImage() %>" alt="" height="90" width="90" style="border-radius: 100%;" >
							</div>
							<div class="name">
								<h3><%=course.getTeacherName() %></h3>
								<p>��<!-- �ΰ����� �Է� --></p>
							</div>
						</div>
						<p class="text_info"><%=course.getTeacherInfo() %></p>
						<ul>
							<li><a href="#"> <i class="fa fa-envelope"></i>
							</a></li>
							<li><a href="#"> <i class="fa fa-twitter"></i>
							</a></li>
							<li><a href="#"> <i class="ti-linkedin"></i>
							</a></li>
						</ul>
					</div>
					<a href="/JSP_PROJECT/board/course/courseSubmit.jsp?coursenum=<%=coursenum %>" class="boxed_btn">���� ��û�ϱ�</a>
					<div class="feedback_info">
						
						<h3>���䳲���<br>(������û�� �л��� ���� �� ����)</h3>
						<p>������ �����ϼ���</p>
						<i class="flaticon-mark-as-favorite-star"></i> <i class="flaticon-mark-as-favorite-star"></i>
						<i class="flaticon-mark-as-favorite-star"></i> <i class="flaticon-mark-as-favorite-star"></i>
						<i class="flaticon-mark-as-favorite-star"></i>

						<form action="#">
							<textarea name="" id="" cols="30" rows="10" placeholder="���� �ı⸦ �����ּ���."></textarea>
							<button type="submit" class="boxed_btn">�� ����ϱ�</button>
						</form>
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>