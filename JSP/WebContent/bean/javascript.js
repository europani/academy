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
		alert('���̵� Ȯ�����ּ���');
		id.focus();
		return;
	}
	if (pwd.value ==="") {
		alert('��й�ȣ�� Ȯ�����ּ���');
		pwd.value.focus();
		return;
	}
	if (repwd.value ==="") {
		alert('��й�ȣ�� Ȯ�����ּ���');
		repwd.focus();
		return;
	}
	if (name.value ==="") {
		alert('�̸��� Ȯ�����ּ���');
		name.focus();
		return;
	}
	if (birthday.value ==="") {
		alert('������ Ȯ�����ּ���');
		birthday.focus();
		return;
	}
	if (email.value ==="") {
		alert('�̸����� Ȯ�����ּ���');
		email.focus();
		return;
	}
	if (pwd.value !== repwd.value) {
		alert('��й�ȣ�� Ȯ�����ּ���');
		repwd.focus();
		return;
	}

	document.regForm.submit();
	
}
