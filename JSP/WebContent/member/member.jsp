<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
<form name="regFrm" method="post" action="memberProc.jsp">
	<input type="text" name="idCheckOk" value="no">
	<table align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td bgcolor="#996600" colspan="3" align="center"><font color="#FFFFFF">ȸ�� ����</font></td>
		</tr>
		<tr>
			<td>���̵�</td>
			<td><input name="id"><input type="button" value="ID�ߺ�Ȯ��" onclick="idCheck(this.form.id.value)"></td>
			<td>���̵� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�н�����</td>
			<td><input name="pwd"></td>
			<td>�н����带 ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�н����� Ȯ��</td>
			<td><input name="repwd"></td>
			<td>�н����带 Ȯ���մϴ�.</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><input name="name"></td>
			<td>�̸��� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>����</td>
			<td>��<input type="radio" name="gender" value="��">��<input type="radio" name="gender" value="��"></td>
			<td>������ ���� �ϼ���.</td>
		</tr>
		<tr>
			<td>�������</td>
			<td><input name="birthday" size="5"> ex)830815</td>
			<td>������ ���� �ϼ���.</td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input name="email"></td>
			<td>�̸����� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�����ȣ</td>
			<td><input id="sample4_postcode" name="zipcode" size="5"><input type="button" value="�����ȣã��" onclick="sample4_execDaumPostcode()"></td>
			<td>�����ȣ�� �˻��ϼ���.</td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td><input id="sample4_roadAddress" name="address" size="50"></td>
			<td>�ּҸ� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>���</td>
			<td>
				���ͳ�<input type="checkbox" name="hobby" value="internet">
				����<input type="checkbox" name="hobby" value="travel">
				����<input type="checkbox" name="hobby" value="game">
				��ȭ<input type="checkbox" name="hobby" value="movie">
				�<input type="checkbox" name="hobby" value="exercise">
			</td>
			<td>��̸� �����ϼ���.</td>
		</tr>
		<tr>
			<td>����</td>
			<td>
				<select name="job">
					<option selected>�����ϼ���.</option>
					<option value="ȸ���">ȸ���</option>
					<option value="�л�">�л�</option>
					<option value="������">������</option>
					<option value="IT">IT</option>
					<option value="�Ƿ�">�Ƿ�</option>
					<option value="�ֺ�">�ֺ�</option>
					<option value="����">����</option>
				</select>					
			</td>
			<td>������ �����ϼ���.</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<input type="submit" value="ȸ������" >
				<input type="reset" value="�ٽþ���" onclick="">
				<input type="button" value="�α���" onclick="">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript">
	function idCheck(id) {
		frm = document.regFrm;
		if (id=="") {
			alert("���̵� �Է����ּ���.");
			fmr.id.focus();
			return;
		}
		url = "idCheck.jsp?id=" + encodeURIComponent(id);
		window.open(url, "IDCheck", "width=300,height=150");
	}
	
	function zipCheck() {
		url = "zipSearch.jsp?search=n";
		window.open(url, "ZipCodeSearch", "width=500,height=300,scrollbars=yes");
	}


</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //�� ���������� ���θ� �ּ� ǥ�� ��Ŀ� ���� ���ɿ� ����, �������� �����͸� �����Ͽ� �ùٸ� �ּҸ� �����ϴ� ����� �����մϴ�.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // ���θ� �ּ��� ���� ��Ģ�� ���� �ּҸ� ǥ���Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var roadAddr = data.roadAddress; // ���θ� �ּ� ����
                var extraRoadAddr = ''; // ���� �׸� ����

                // ���������� ���� ��� �߰��Ѵ�. (�������� ����)
                // �������� ��� ������ ���ڰ� "��/��/��"�� ������.
                if(data.bname !== '' && /[��|��|��]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // �ǹ����� �ְ�, ���������� ��� �߰��Ѵ�.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // ǥ���� �����׸��� ���� ���, ��ȣ���� �߰��� ���� ���ڿ��� �����.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
            }
        }).open();
        
    }
</script>
</body>
</html>