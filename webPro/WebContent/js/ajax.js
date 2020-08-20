const check = document.querySelector('#idcheck');
	
	function idCheck(id) {
		if (id.length < 8) {
			check.innerHTML = '8자이상 입력해주세요.';
		} else {
			idcheckOfServer(id);
		}
		url = "idCheck.jsp?id=" + id;
	}
	
	function idcheckOfServer(id) {
		let xhttp = new XMLHttpRequest();
		let params = "?id=" + encodeURIComponent(id);
		xhttp.open("GET", "/webPro/nohead/idCheck.jsp" + params);
		xhttp.send();
		
		xhttp.onreadystatechange = function () {
			if (this.readyState == 4 && this.status == 200) {
				let str = this.responseText;
				check.innerHTML = str;
			}
		};
	}