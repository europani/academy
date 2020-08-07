let body = document.querySelector("body");
let id = body.querySelector("input[name=id]");
let pwd = body.querySelector("input[name=pwd]");
let repwd = body.querySelector("input[name=repwd]");
let name = body.querySelector("input[name=name]");
let birthday = body.querySelector("input[name=birthday]");
let email = body.querySelector("input[name=email]");

function inputCheck() {
//	document.regForm.id.value
	if (id.value ==="") {
		alert('아이디를 확인해주세요');
		id.focus();
		return;
	}
	if (pwd.value ==="") {
		alert('비밀번호를 확인해주세요');
		pwd.value.focus();
		return;
	}
	if (repwd.value ==="") {
		alert('비밀번호를 확인해주세요');
		repwd.focus();
		return;
	}
	if (name.value ==="") {
		alert('이름을 확인해주세요');
		name.focus();
		return;
	}
	if (birthday.value ==="") {
		alert('생일을 확인해주세요');
		birthday.focus();
		return;
	}
	if (email.value ==="") {
		alert('이메일을 확인해주세요');
		email.focus();
		return;
	}
	if (pwd.value !== repwd.value) {
		alert('비밀번호를 확인해주세요');
		repwd.focus();
		return;
	}

	document.regForm.submit();
	
}
