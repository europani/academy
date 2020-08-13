function inputCheck() {
	let chkbox = document.regFrm.hobby;
	let chkboolean = false;
	
	for (var i = 0; i < chkbox.length; i++) {
		if (chkbox[i].checked == true) {
			chkboolean = true;
		}
	}
	
	if (document.regFrm.idCheckOk.value != "yes") {
		alert("id 중복확인 하세요");
		document.regFrm.id.focus();
		return;
	}
	if (document.regFrm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.regFrm.pwd.focus();
		return;
	}
	if (document.regFrm.repwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.regFrm.repwd.focus();
		return;
	}
	if (document.regFrm.repwd.value !== document.regFrm.pwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.regFrm.repwd.focus();
		return;
	}
	if (document.regFrm.name.value == "") {
		alert("이름을 입력하세요.");
		document.regFrm.name.focus();
		return;
	}
	if (document.regFrm.gender.value == "") {
		alert("성별을 선택하세요.");
		document.regFrm.gender.focus();
		return;
	}
	if (document.regFrm.birthday.value == "") {
		alert("생일을 입력하세요.");
		document.regFrm.birthday.focus();
		return;
	}
	if (document.regFrm.email.value == "") {
		alert("이메일을 입력하세요.");
		document.regFrm.email.focus();
		return;
	}
	if (document.regFrm.zipcode.value == "") {
		alert("우편번호를 입력하세요.");
		document.regFrm.zipcode.focus();
		return;
	}
	if (document.regFrm.address.value == "") {
		alert("주소를 입력하세요.");
		document.regFrm.address.focus();
		return;
	}
	if (!chkboolean) {
		alert("취미를 한개이상 선택하세요");
		return;
	}
	if (document.regFrm.job.value == "선택하세요.") {
		alert("직업을 선택하세요.");
		document.regFrm.job.focus();
		return;
	}
	document.regFrm.submit();
}

function inputCheck2() {
	let chkbox = document.updateFrm.hobby;
	let chkboolean = false;
	
	for (var i = 0; i < chkbox.length; i++) {
		if (chkbox[i].checked == true) {
			chkboolean = true;
		}
	}
	
	if (document.updateFrm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.updateFrm.pwd.focus();
		return;
	}
	if (document.updateFrm.repwd.value == "") {
		alert("비밀번호를 입력하세요.");
		document.updateFrm.repwd.focus();
		return;
	}
	if (document.updateFrm.repwd.value !== document.updateFrm.pwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.updateFrm.repwd.focus();
		return;
	}
	if (document.updateFrm.name.value == "") {
		alert("이름을 입력하세요.");
		document.updateFrm.name.focus();
		return;
	}
	if (document.updateFrm.gender.value == "") {
		alert("성별을 선택하세요.");
		document.updateFrm.gender.focus();
		return;
	}
	if (document.updateFrm.birthday.value == "") {
		alert("생일을 입력하세요.");
		document.updateFrm.birthday.focus();
		return;
	}
	if (document.updateFrm.email.value == "") {
		alert("이메일을 입력하세요.");
		document.updateFrm.email.focus();
		return;
	}
	if (document.updateFrm.zipcode.value == "") {
		alert("우편번호를 입력하세요.");
		document.updateFrm.zipcode.focus();
		return;
	}
	if (document.updateFrm.address.value == "") {
		alert("주소를 입력하세요.");
		document.updateFrm.address.focus();
		return;
	}
	if (!chkboolean) {
		alert("취미를 한개이상 선택하세요");
		return;
	}
	if (document.updateFrm.job.value == "선택하세요.") {
		alert("직업을 선택하세요.");
		document.updateFrm.job.focus();
		return;
	}
	document.updateFrm.submit();
}

