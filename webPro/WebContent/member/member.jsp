<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>
</head>
<body>
<form name="regFrm" method="post" action="memberProc.jsp">
	<input type="hidden" name="idCheckOk" value="no">
	<table align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td bgcolor="#996600" colspan="3" align="center"><font color="#FFFFFF">ȸ�� ����</font></td>
		</tr>
		<tr>
			<td>���̵�</td>
			<td>
				<input name="id" onkeyup="idCheck(this.form.id.value)">
				<span id="idcheck"></span>
			</td>
			<td>���̵� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�н�����</td>
			<td><input name="pwd" type="password"></td>
			<td>�н����带 ���� �ּ���.</td>
		</tr>
		<tr>
			<td>�н����� Ȯ��</td>
			<td><input name="repwd" type="password"></td>
			<td>�н����带 Ȯ���մϴ�.</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><input name="name"></td>
			<td>�̸��� ���� �ּ���.</td>
		</tr>
		<tr>
			<td>����</td>
			<td>��<input type="radio" name="gender" value="1">��<input type="radio" name="gender" value="2"></td>
			<td>������ ���� �ϼ���.</td>
		</tr>
		<tr>
			<td>�������</td>
			<td><input name="birthday" size="5"> ex)830815</td>
			<td>��������� �Է� �ϼ���.</td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email"></td>
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
				<input type="button" value="ȸ������" onclick="inputCheck()">
				<input type="reset" value="�ٽþ���">
				<input type="button" value="�α���" onclick="location.href = 'login.jsp'">
			</td>
		</tr>
	</table>
</form>

<script src="/webPro/js/ajax.js" type="text/javascript"></script>
<script src="/webPro/js/javascript.js" type="text/javascript"></script>
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