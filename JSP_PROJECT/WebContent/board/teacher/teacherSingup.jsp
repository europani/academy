<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!-- bradcam_area_start -->
<div class="bradcam_area breadcam_bg overlay2">
	<h3>�ܵ��</h3>
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
						<h3 class="mb-30">������</h3>
						<div class="mt-10">
							<p>�ܻ���</p>
							<div class="file-input">
								<input type="text" readonly="readonly" id="fileRoute" required class="fileRoute"> <label
									for="teacherImage">���� ���ε� <input name="teacherImage" type="file"
									onchange="javascript:document.getElementById('fileRoute').value=this.value"
									id="teacherImage">
								</label>
							</div>
						</div>
						<div class="mt-10">
							<p>�ܼҰ�</p>
							<textarea name="teacherInfo" class="single-textarea" placeholder="�Ұ����� �ۼ����ּ���."
								onfocus="this.placeholder = ''" onblur="this.placeholder = '�Ұ����� �ۼ����ּ���.'" required></textarea>
						</div>
					</div>


					<div id="course">

						<h3 class="mb-30">
							<br>���� ����
						</h3>

						<div class="mt-10">
							<p>���� �̸�</p>
							<input type="text" name="title" placeholder="������" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '���� �̸�'" required class="single-input">
						</div>
						<p>ī�װ�</p>
						<div class="input-group-icon mt-10">

							<div class="icon">
								<i class="fa fa-folder-open-o" aria-hidden="true"></i>
							</div>
							<div class="form-select" id="default-select">
								<select name="category">
									<option selected="selected" disabled>ī�װ�</option>
									<option value="������">������</option>
									<option value="�ǹ�����">�ǹ�����</option>
									<option value="��Ƽ">��Ƽ</option>
									<option value="����">����</option>
									<option value="�ܱ���">�ܱ���</option>
									<option value="����">����</option>
									<option value="��������Ÿ��">��������Ÿ��</option>
									<option value="��Ÿ">��Ÿ</option>
								</select>
							</div>
						</div>

						<div class="mt-10">
							<p>���� ���̵�</p>

							<input type="text" name="difficulty" placeholder="���̵�" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '���� ���̵�'" required class="single-input">
						</div>
						<div class="mt-10">
							<p>���� ����</p>

							<input type="text" name="maxppl" placeholder="���� ����" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '���� ����'" required class="single-input">
						</div>
						<div class="mt-10">
							<p>���� ���</p>

							<input type="text" name="address" placeholder="���� ���" onfocus="this.placeholder = ''"
								onblur="this.placeholder = '���� ���'" required class="single-input">
						</div>
						<div class="mt-10">
							<p>���� �Ұ�</p>

							<textarea name="content" class="single-textarea" placeholder="���� �Ұ�"
								onfocus="this.placeholder = ''" onblur="this.placeholder = '���� �Ұ�'" required></textarea>
						</div>
						<div class="mt-10">
							<p>���� ����</p>

							<textarea name="notice" class="single-textarea" placeholder="���� ����"
								onfocus="this.placeholder = ''" onblur="this.placeholder = '���� ����'" required></textarea>
						</div>
						<div class="mt-10">
							<p>���� �̹���</p>
							<div class="file-input">
								<input type="text" readonly="readonly" id="fileRoute2" required class="fileRoute"> <label
									for="courseImage">���� ���ε� <input name="courseImage" type="file"
									onchange="javascript:document.getElementById('fileRoute2').value=this.value"
									id="courseImage">
								</label>
							</div>
						</div>
					</div>
					<button type="submit" class="boxed_btn_orange">�ܵ��</button>
				</form>
			</div>
		</div>
	</div>
</div>
