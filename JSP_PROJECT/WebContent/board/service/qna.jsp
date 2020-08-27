<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<style type="text/css">
	#block {
		padding : 10px 0;
	}
</style>
<div class="bradcam_area breadcam_bg overlay2">
	<h3>FAQ 자주 묻는 질문</h3>
</div>	
<head>
<title>FAQ 자주 묻는 질문</title>
<meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>	
<div class="our_courses">
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">세모셈</a></li>
    <li><a data-toggle="tab" href="#menu1">수강생</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
    <div id="block">
      <h3>수업 신청 후 절차가 어떻게 되나요?</h3>
      <p> 수업신청은 " 수업신청서 발급 >> 결제완료 >> 튜터님의 수업승인  >> 수업매칭" 으로 절차가 진행됩니다!<br> 튜터님과 연결되시면 일정을 조율하여 첫 수업날짜를 잡아보세요</p>
    </div>
      <div id="block">              
      <h3>수업장소와 시간은 어떻게 되나요?</h3>
      <p> 수업소개에 수업장소와 시간이 명시되어 있습니다. 자세히 명시 되어있지 않은 수업의 경우 튜터와 조율하여 유동적으로 결정할 수 있습니다.<br>
                    튜터에게 문의하여 시간을 조율해보세요. 개개인의 스케줄에 딱 맞는 시간을 조율할 수 있다는 것이 탈잉의 가장 큰 장점이니까요.</p>
      </div>
      <div id="block">              
      <h3>수업을 신청하기 전, 튜터님께 수업의 커리큘럼 혹은 일정에 관해 어떻게 질문을 할 수 있나요?</h3>
      <p>수업소개서 안에 있는 실시간톡을 클릭하여 튜터님과 수업신청 전에 커리큘럼 혹은 일정에 관해 이야기 해보세요.</p>
      </div>
      <div id="block">
      <h3>튜터들의 수업 퀄리티를 신뢰할 수 있을까요?</h3>
      <p>탈잉에서 튜터에 대한 철저한 사전검증을 하게 되며, 프로필 상의 경력과 자격증에 대한 검수확인 과정을 거치게 됩니다.<br>
                    또한 실제 수업을 들었던 수강생의 리뷰와 피드백을 통해 튜터의 평판을 지속적으로 관리합니다. 탈잉은 계속해서 튜터들의 신뢰도를 높일 수 있는 검증 시스템을 만들어 갈 것임을 약속드립니다.</p>
	  </div>
	  <div id="block">	                    
      <h3>수업 취소는 어떻게 할 수 있나요?</h3>
      <p>첫 수업 24시간 전에 튜터님께 수업취소의사를 전달해주시길 바랍니다.  그 다음, 홈페이지 하단
      <span id="custom-button-1" style="cursor:pointer;font-size: 14px;color:#ff0041;">
      <img src="https://front-img.taling.me/Content/Images/icon_talingtalk.png" style="height:18px;vertical-align:text-bottom">
      	세모쌤에 문의하기</span> 를 통해 세금계산서 문의를 해주세요.
                    를 통해 취소 여부를 알려주세요.</p>
      </div>
      <div id="block">              
      <h3>첫 수업 시작 전에 급한 일이 생겼습니다. 환불이 가능할까요?</h3>
      <p>첫 수업 24시간 전에 튜터님께 수업취소의사를 전달해주신 경우에는 결제된 수업료가 100% 환불됩니다. 자세한 사안은 환불규정을 참고해주세요</p>
      </div>
      <div id="block">
      <h3>환불 절차는 어떻게 되나요?</h3>
      <p> “튜터에게 환불 의사 전달 > 환불 신청 > 담당자 확인 후 환불 접수(환불 신청 후 운영 시간 기준 24시간 이내 완료) > 
      환불 진행 (무통장 재입금 : 영업일 기준 평균 2,3일 / 카드 결제 취소 : 영업일 기준 평균 3,4일) > 환불 완료” 의 절차로 진행됩니다.</p>
      </div>
      <div id="block">
      <h3>수업 중간에 사정이 생겨 그만 둘 경우에도 환불이 되나요?</h3>
      <p>첫 수업 이후 환불에 대해서는 회원가입 및 결제 시 수강생이 동의한 탈잉의 환불 규정에 따라 환불이 진행됩니다.<br>
                    자세한 사안은 환불규정을 참고해주세요.</p>
	  <div id="block">
	  <h3>회원탈퇴는 어떻게 하나요?</h3>
	  <p>  앱 : 마이탈잉 > 연필 모양 버튼 > 회원 탈퇴<br>
                                            PC : 탈퇴를 원하시면 <a href="/Account/LoginPage.php" onclick="alert('로그인을 먼저 진행해주세요');"><font color="#f82462" style="text-decoration:underline;">여기</font></a>를 눌러주세요.
                                        <br>
                    회원 탈퇴를 하시면 해당 아이디는 영업일 기준 최대 3일 이내 탈퇴 처리되며, 탈잉 서비스 이용약관에 근거한 이용계약 종료 시 당사는 회원님의 개인정보 또한 파기합니다.</p>
	  </div>	                    
    </div>              
    </div>
    <div id="menu1" class="tab-pane fade">
    <div id="block">
      <h3>수업 등록은 아무나 할 수 있나요?</h3>
      <p> 누구나 수업 등록을 하실 수 있습니다.<br>
                    단, 신분증 / 대학교 / 대학원인증 중 1개의 인증으로 신분인증을 해주셔야 합니다. 또한 튜터로서 활동하실때 수강생분들과 연락하실 연락처 인증을 해주셔야 합니다.<br>
                    수업 등록 후 관리자의 최종 승인이 있어야 홈페이지에 게시되고 신청을 받을 수 있습니다. 관리자는 등록된 수업내용, 이미지, 튜터 프로필 등의 적절성, 사실확인을 검증한 이후 최종 승인을 해드립니다.</p>
    </div>
    <div id="block">                
       <h3>수업 등록은 어떻게 하나요?</h3>
      <p> 수업 등록은 앱과 PC에서 모두 가능합니다.<br>
                    다만, PC에서 최적화 되어 있어 최초 등록 시에는 PC 사용을 권장 드립니다.<br>
                    앱 : 마이 탈잉 > 튜터모드로 > 수업관리 > “수업 추가” 버튼<br>
                    PC : 로그인 > 상단의 “튜터“ 버튼 > “새로운 수업 추가” 버튼</p>
    </div>
    <div id="block">                
       <h3>수업은 어디서 진행하면 되나요?</h3>
      <p> 기본적으로 튜터님께서 수업소개서에 작성해주신 곳에서 수업을 진행해주시면 됩니다.<br>
                    (EX. 카페, 스터디룸, 튜터님 개인 스튜디오 등)<br>
                    자유롭게 장소를 정하여 수업을 진행하는 것이 탈잉의 장점이니까요!<br></p>
    </div>
    <div id="block">                
       <h3>수업 등록후 승인까지 얼마나 걸리나요?</h3>
      <p>튜터님께서 작성해주신 수업소개서는 탈잉의 검토단분들이 꼼꼼히 검토하고 있습니다. 수업승인은 먼저 등록해주신 순서대로 진행되고 있으며 영업일 기준 평균 5일 정도 소요됩니다.
       <br>
                    수업승인 반려 후 재승인 요청 해주시는 경우에도 처음부터 다시 심사가 진행되니 모든 내용을 완벽하게 작성하신 후에 제출해주시는 것이 좋습니다.</p>
     </div> 
     <div id="block">
       <h3>수강생이 수업을 신청하면 어디서 확인 할 수 있나요?</h3>
      <p>앱 : 마이 탈잉 > 튜터모드로 > 수업신청서 > 승인대기<br>
                    PC : 로그인 > 상단의 “튜터”메뉴 > 수업신청서</p>
     </div> 
      <div id="block">
       <h3>수강생이 신청한 수업신청서를 반려할 때는 어떻게 하나요?</h3>
      <p> 해당 수강신청서를 클릭하여 “반려＂버튼을 누르고 수강생이 확인할 반려메시지를 정중하게 작성하고 “확인＂버튼을 눌러주시면 반려가 완료됩니다.</p>
 	</div>
 	</div>
      </div>
    </div>
  </div>
</body>
</html>
          
         
        
