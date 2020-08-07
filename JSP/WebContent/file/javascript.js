function inputValue(form1, param, form2, idx) {
		let paramValue = form1.elements[idx].value;
		form2.elements[idx].value = paramValue;
		return;	
	}
	
	function addFile(formName) {
		if (formName.addcnt.value=="") {
			alert("입력할 파일 갯수를 입력하고 확인버튼을 눌러주세요");
			formName.addcnt.focus();
			return;
		}
		formName.submit();
	}

	function elementCheck(formName) {
		paramIndex = 1;
		for (idx = 0; idx < formName.elements.length; idx++) {
			if (formName.elements[idx].type == "file") {
				if (formName.elements[idx].value=="") {
					let message = paramIndex + "번째 파일정보가 누락되었습니다.\n 업로드할 파일을 선택해 주세요.";
					alert(message);
					formName.elements[idx].focus();
					return;
				}
				paramIndex++;
			}
		}
		formName.action = "fileInfoView.jsp";
		formName.submit();
	}