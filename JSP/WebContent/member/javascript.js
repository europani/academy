function inputCheck() {
	let chkbox = document.regFrm.hobby;
	let chkboolean = false;
	
	for (var i = 0; i < chkbox.length; i++) {
		if (chkbox[i].checked == true) {
			chkboolean = true;
		}
	}
	
	if (document.regFrm.idCheckOk.value != "yes") {
		alert("id �ߺ�Ȯ�� �ϼ���");
		document.regFrm.id.focus();
		return;
	}
	if (document.regFrm.pwd.value == "") {
		alert("��й�ȣ�� �Է��ϼ���.");
		document.regFrm.pwd.focus();
		return;
	}
	if (document.regFrm.repwd.value == "") {
		alert("��й�ȣ�� �Է��ϼ���.");
		document.regFrm.repwd.focus();
		return;
	}
	if (document.regFrm.repwd.value !== document.regFrm.pwd.value) {
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		document.regFrm.repwd.focus();
		return;
	}
	if (document.regFrm.name.value == "") {
		alert("�̸��� �Է��ϼ���.");
		document.regFrm.name.focus();
		return;
	}
	if (document.regFrm.gender.value == "") {
		alert("������ �����ϼ���.");
		document.regFrm.gender.focus();
		return;
	}
	if (document.regFrm.birthday.value == "") {
		alert("������ �Է��ϼ���.");
		document.regFrm.birthday.focus();
		return;
	}
	if (document.regFrm.email.value == "") {
		alert("�̸����� �Է��ϼ���.");
		document.regFrm.email.focus();
		return;
	}
	if (document.regFrm.zipcode.value == "") {
		alert("�����ȣ�� �Է��ϼ���.");
		document.regFrm.zipcode.focus();
		return;
	}
	if (document.regFrm.address.value == "") {
		alert("�ּҸ� �Է��ϼ���.");
		document.regFrm.address.focus();
		return;
	}
	if (!chkboolean) {
		alert("��̸� �Ѱ��̻� �����ϼ���");
		return;
	}
	if (document.regFrm.job.value == "�����ϼ���.") {
		alert("������ �����ϼ���.");
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
		alert("��й�ȣ�� �Է��ϼ���.");
		document.updateFrm.pwd.focus();
		return;
	}
	if (document.updateFrm.repwd.value == "") {
		alert("��й�ȣ�� �Է��ϼ���.");
		document.updateFrm.repwd.focus();
		return;
	}
	if (document.updateFrm.repwd.value !== document.updateFrm.pwd.value) {
		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		document.updateFrm.repwd.focus();
		return;
	}
	if (document.updateFrm.name.value == "") {
		alert("�̸��� �Է��ϼ���.");
		document.updateFrm.name.focus();
		return;
	}
	if (document.updateFrm.gender.value == "") {
		alert("������ �����ϼ���.");
		document.updateFrm.gender.focus();
		return;
	}
	if (document.updateFrm.birthday.value == "") {
		alert("������ �Է��ϼ���.");
		document.updateFrm.birthday.focus();
		return;
	}
	if (document.updateFrm.email.value == "") {
		alert("�̸����� �Է��ϼ���.");
		document.updateFrm.email.focus();
		return;
	}
	if (document.updateFrm.zipcode.value == "") {
		alert("�����ȣ�� �Է��ϼ���.");
		document.updateFrm.zipcode.focus();
		return;
	}
	if (document.updateFrm.address.value == "") {
		alert("�ּҸ� �Է��ϼ���.");
		document.updateFrm.address.focus();
		return;
	}
	if (!chkboolean) {
		alert("��̸� �Ѱ��̻� �����ϼ���");
		return;
	}
	if (document.updateFrm.job.value == "�����ϼ���.") {
		alert("������ �����ϼ���.");
		document.updateFrm.job.focus();
		return;
	}
	document.updateFrm.submit();
}

