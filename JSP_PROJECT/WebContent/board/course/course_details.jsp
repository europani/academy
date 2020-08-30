<%@page import="com.semosam.dto.reviewDTO"%>
<%@page import="com.semosam.dao.reviewDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.semosam.dto.scheduleDTO"%>
<%@page import="com.semosam.dao.scheduleDAO"%>
<%@page import="com.semosam.dto.courseDTO"%>
<%@page import="com.semosam.dao.courseDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<%
	int coursenum = Integer.parseInt(request.getParameter("coursenum"));
	courseDAO cDao = new courseDAO();
	courseDTO course = cDao.getCourse(coursenum);
	String shortAddr = course.getAddress().substring(0, 7);
	scheduleDAO sDao = new scheduleDAO();
	ArrayList<String> days = sDao.getDistinctWeekday(coursenum);
	ArrayList<String> time = sDao.getDistinctTime(coursenum);
	
	reviewDAO rDao = new reviewDAO();
	int countReview = rDao.getCountReview(coursenum);
	ArrayList<reviewDTO> reviewList = rDao.getReviews(coursenum);
	
	String email = (String)session.getAttribute("idKey");
	memberDAO mDao = new memberDAO();
	int memnum = mDao.getMemnum(email);
	
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
						<span>후기 <%=countReview %>건</span>
					</div>
					<div class="hours">
						<div class="video">
							<div class="single_video">
								<table>
								<tr>
								<td align="center" style="padding-right: 10px;"><i class="ti-calendar"></i></td>
								<td><span>
								<% 
									if(days.size() != 0) {
										for(int i = 0; i < days.size(); i++) {
								%>
												<%=days.get(i)%>
								<%}} else { %>
									등록된 수업 일정이 없습니다.
								<%} %>
								</span></td>
								</tr>
								<tr>
								<td align="center" style="padding-right: 10px;"><i class="fa fa-clock-o"></i></td>
								<td><span>
								<% 
									if(time.size() != 0) {
										for(int i = 0; i < time.size(); i++) {
								%>
												<%=time.get(i)%>
								<%}} else { %>
									등록된 수업 일정이 없습니다.
								<%} %>
								
								</span></td>
								</tr>
								<tr>
								<td align="center" style="padding-right: 10px;"><i class="fa fa-thumb-tack" aria-hidden="true"></i></td>
								<td><span><%=shortAddr %></span></td>
								</tr>
								</table>
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
			<!-- 수업명, 수업내용 -->
			<div class="col-xl-7 col-lg-7">
				<div class="single_courses">
					<h3><%=course.getTitle() %></h3>
					<p><%=course.getContent() %></p>
				</div>
				
				<!-- 수업 안내사항 -->
				<div class="outline_courses_info" style="margin-top: 50px">
				<h2 class="second_title">수업 안내사항</h2>
					<div id="accordion" style="margin-top: 20px">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne"
										aria-expanded="false" aria-controls="collapseOne">
										<i class="flaticon-question"></i> 수업 관련 공지
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
										<i class="flaticon-question"></i> 수업 제한 인원
									</button>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
								<div class="card-body">수업은 최대 <%=course.getMaxppl() %>명으로 진행됩니다.</div>
							</div>
						</div>
						
						<div class="card">
							<div class="card-header" id="headingThree">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">
										<i class="flaticon-question"></i> 수업 장소
									</button>
								</h5>
							</div>
							<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
								<div class="card-body">주소<p><%=course.getAddress() %></p></div>
							</div>
						</div>
						
					</div>
				</div>
				
				<!-- 리뷰 조회 -->
				<div class="outline_courses_info" style="margin-top: 50px">
				<h2 class="second_title"><%=course.getTeacherName() %> 쌤 학생들의 리뷰</h2>
					<div id="accordion" style="margin-top: 20px">
						<div class="card">
							<div class="card-header" id="review">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseReview"
										aria-expanded="false" aria-controls="collapseReview">
										<i class="flaticon-mark-as-favorite-star" style="color: orange"></i> 리뷰
									</button>
								</h5>
							</div>
							<div id="collapseReview" class="collapse" aria-labelledby="review" data-parent="#accordion">
								<div class="card-body">
								
								<% 
									if(reviewList.size() > 0) {
										for(int i = 0; i < reviewList.size(); i++) {%>
										학생 중 <%=i+1 %>번째 리뷰 : <%=reviewList.get(i).getContent() %> / 
										<b>점수 : <%=reviewList.get(i).getStarscore() %></b><br>
									<%}} else {%>
									<b>등록된 리뷰가 없습니다.</b>
									<%} %>
								</div>
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
								<h3><%=course.getTeacherName() %> 쌤</h3>
								<p>　<!-- 부가정보 입력 --></p>
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
					<a href="/JSP_PROJECT/board/course/courseSubmit.jsp?coursenum=<%=coursenum %>" class="boxed_btn">수업 신청하기</a>
					<button type="button" class="boxed_btn_orange" OnClick="window.location='/JSP_PROJECT/board/course/makingWish.jsp?memnum=<%=memnum%>&coursenum=<%=coursenum %>'">찜하기</button>
					
					<!-- 
					<div class="feedback_info">
						
						<h3>리뷰 남기기<br>(수업신청한 학생만 남길 수 있음)</h3>
						
						<form action="#">
							<textarea name="" id="" cols="30" rows="10" placeholder="수업 후기를 남겨주세요."></textarea>
							<button type="submit" class="boxed_btn">평가 등록하기</button>
						</form>
					</div>
					 -->
				</div>
			</div>
		</div>
	</div>
</div>