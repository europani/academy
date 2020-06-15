import java.io.*;
import java.util.*;

public class Member {
	Map<String, String> member = new HashMap<String, String>();
	Scanner sc = new Scanner(System.in);
	String id;
	String password;
	boolean isLogin;

	public Member() {}

	Member(String id, String password) {
		this.id = id;
		this.password = password;
	}


	public void signUp() throws IOException {
		System.out.println("ID�� �Է����ּ���.");
		id = sc.nextLine();
		System.out.println("password�� �Է����ּ���.");
		password = sc.nextLine();
		member.put(id, password);
		FileWriter fw = new FileWriter(new File("src/member.txt"), true);
		fw.write(new Member(id, password).toTxt());
		fw.close();
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�. �α������ּ���.");
		login();
	}

	public void login() throws FileNotFoundException {
		if (isLogin == true) {
			System.out.println("�̹� �α��� �Ǿ��ֽ��ϴ�.");
		}
		while (isLogin == false) {
			System.out.println("======�α���======[�����޴� : 0]");
			System.out.println("ID�� �Է����ּ���.");
			String inputID = sc.nextLine();
			if (inputID.equals("0"))
				break;

			System.out.println("password�� �Է����ּ���.");
			String inputPassword = sc.nextLine();
			if (member.containsKey(inputID)) {
				if (member.get(inputID).equals(inputPassword)) {
					System.out.println("�α��� �Ǿ����ϴ�.");
					isLogin = true;
					break;
				} else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
				}
			} else {
				System.out.println("ID�� �������� �ʽ��ϴ�.");
			}
		}
		
	}

	String toTxt() {
		return id + ", " + password+"\r\n";
	}

}
