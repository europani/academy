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
		System.out.println("ID를 입력해주세요.");
		id = sc.nextLine();
		System.out.println("password를 입력해주세요.");
		password = sc.nextLine();
		member.put(id, password);
		FileWriter fw = new FileWriter(new File("src/member.txt"), true);
		fw.write(new Member(id, password).toTxt());
		fw.close();
		System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
		login();
	}

	public void login() throws FileNotFoundException {
		if (isLogin == true) {
			System.out.println("이미 로그인 되어있습니다.");
		}
		while (isLogin == false) {
			System.out.println("======로그인======[이전메뉴 : 0]");
			System.out.println("ID를 입력해주세요.");
			String inputID = sc.nextLine();
			if (inputID.equals("0"))
				break;

			System.out.println("password를 입력해주세요.");
			String inputPassword = sc.nextLine();
			if (member.containsKey(inputID)) {
				if (member.get(inputID).equals(inputPassword)) {
					System.out.println("로그인 되었습니다.");
					isLogin = true;
					break;
				} else {
					System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
				}
			} else {
				System.out.println("ID가 존재하지 않습니다.");
			}
		}
		
	}

	String toTxt() {
		return id + ", " + password+"\r\n";
	}

}
