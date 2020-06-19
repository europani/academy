package teamProject3;
import java.io.*;
import java.util.*;

public class Member {
	Map<String, String> member = new HashMap<String, String>();
	String id;
	String password;
	boolean isLogin;
	
	PrintWriter out;
	BufferedReader in;
	
	private Member(String id, String password) {
		this.id = id;
		this.password = password;
	}

	Member(PrintWriter out, BufferedReader in) {
		this.out = out;
		this.in = in;
	}


	public void signUp(String id, String password) throws IOException {
		member.put(id, password);
		FileWriter fw = new FileWriter(new File("src/teamProject3/member.txt"), true);
		fw.write(new Member(id, password).toTxt());
		fw.close();
		out.println("회원가입이 완료되었습니다.");
	}

	public void login(String inputID, String inputPassword) throws IOException {
			if (member.containsKey(inputID)) {
				if (member.get(inputID).equals(inputPassword)) {
					out.println("로그인 되었습니다.");
					isLogin = true;
				} else {
					out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
				}
			} else {
				out.println("ID가 존재하지 않습니다.");
			}
		
	}

	String toTxt() {
		return id + ", " + password+"\r\n";
	}

}
