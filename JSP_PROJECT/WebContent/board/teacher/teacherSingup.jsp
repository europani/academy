<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!-- bradcam_area_start -->
<div class="bradcam_area breadcam_bg overlay2">
	<h3>쌤등록</h3>
</div>
<!-- bradcam_area_end -->
<div class="our_courses">
	<div class="container">
		<div class="row">
			<!-- <div class="col-xl-12">
				<div class="section_title text-center mb-100">
					<h3>Popular Courses</h3>
					<p>
						Your domain control panel is designed for ease-of-use and <br> allows for all aspects of
						your domains.
					</p>
				</div>
			</div> -->
		</div>
		<div class="row">
			<div class="col-xl-8 col-lg-8 col-md-8" id="teacherSingup">
				<form action="/JSP_PROJECT/board/teacher/teacherSignupProc.jsp" method="post"
					enctype="multipart/form-data">
					<div id="teacher">
						<h3 class="mb-30">쌤정보</h3>
						<div class="mt-10">
							<p>쌤사진</p>
							<div class="file-input">
								<input type="text" readonly="readonly" id="fileRoute" required class="fileRoute"> <label
									for="teacherImage">사진 업로드 <input name="teacherImage" type="file"
									onchange="javascript:document.getElementById('fileRoute').value=this.value"
									id="teacherImage">
								</label>
							</div>
						</div>
						<div class="mt-10">
							<p>쌤소개</p>
							<textarea name="teacherInfo" class="single-textarea" placeholder="소개글을 작성해주세요."
								onfocus="this.placeholder = ''" onblur="this.placeholder = '소개글을 작성해주세요.'" required></textarea>
						</div>
					</div>


					<div id="course">

						<h3 class="mb-30">
							<br>수업 정보
						</h3>

						<div class="mt-10">
							<p>수업 이름</p>
							<input type="text" name="title" placeholder="수업명" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '수업 이름'" required class="single-input">
						</div>
						<p>카테고리</p>
						<div class="input-group-icon mt-10">

							<div class="icon">
								<i class="fa fa-folder-open-o" aria-hidden="true"></i>
							</div>
							<div class="form-select" id="default-select">
								<select name="category">
									<option selected="selected" disabled>카테고리</option>
									<option value="디자인">디자인</option>
									<option value="실무역량">실무역량</option>
									<option value="뷰티">뷰티</option>
									<option value="영상">영상</option>
									<option value="외국어">외국어</option>
									<option value="음악">음악</option>
									<option value="라이프스타일">라이프스타일</option>
									<option value="기타">기타</option>
								</select>
							</div>
						</div>

						<div class="mt-10">
							<p>수업 난이도</p>

							<input type="text" name="difficulty" placeholder="난이도" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '수업 난이도'" required class="single-input">
						</div>
						<div class="mt-10">
							<p>수업 정원</p>

							<input type="text" name="maxppl" placeholder="수어 정원" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '수업 정원'" required class="single-input">
						</div>
						<div class="mt-10">
							<p>수업 장소</p>

							<input type="text" name="address" placeholder="수업 장소" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '수업 장소'" required class="single-input">
						</div>
						<div class="mt-10">
							<p>수업 소개</p>

							<textarea name="content" class="single-textarea" placeholder="수업 소개"
								onfocus="this.placeholder = ''" onblur="this.placeholder = '수업 소개'" required></textarea>
						</div>
						<div class="mt-10">
							<p>수업 공지</p>

							<textarea name="notice" class="single-textarea" placeholder="수업 공지"
								onfocus="this.placeholder = ''" onblur="this.placeholder = '수업 공지'" required></textarea>
						</div>
						<div class="mt-10">
							<p>수업 이미지</p>
							<div class="file-input">
								<input type="text" readonly="readonly" id="fileRoute2" required class="fileRoute"> <label
									for="courseImage">사진 업로드 <input name="courseImage" type="file"
									onchange="javascript:document.getElementById('fileRoute2').value=this.value"
									id="courseImage">
								</label>
							</div>
						</div>
					</div>
					<button type="submit" class="boxed_btn_orange">쌤등록</button>
				</form>
			</div>
		</div>
	</div>
</div>
