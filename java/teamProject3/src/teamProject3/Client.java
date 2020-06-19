package teamProject3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Scanner sc = new Scanner(System.in);
	String input;

	Socket socket = null;
	PrintWriter out;
	BufferedReader in;

	public void connect() {
		String serverIp = "127.0.0.1";
		int port = 7777;
		try {
			socket = new Socket(serverIp, port);
			System.out.println(socket.getInetAddress() + " 서버에 연결되었습니다.");

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void sendToServer(String name) throws IOException { 
		out.println(name);
		
		try { 	// Server -> Client
			String line = in.readLine();
			line = line.replace(";", "\n");
			System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void buyBookClient() throws IOException {
		System.out.println("구매하실 도서명을 입력해주세요.");
		input = sc.nextLine();
		out.println(input);
		System.out.println(in.readLine());
	}
	

	public void init() throws IOException {
		while (true) {
			Ui.mainUi();
			input = sc.nextLine();

			switch (input) {
			case "1":
				check();
				break;
			case "2":
				buy();
				break;
			case "3":
				history();
				break;
			case "4":
				System.out.println("======회원가입======[이전메뉴 : 0]");
				System.out.println("ID를 입력해주세요.");
				input = sc.nextLine();
				if (input.equals("0")) break;
				System.out.println("password를 입력해주세요.");
				input += " " + sc.nextLine();
				sendToServer("signUp 4;" + input);
				
				break;
			case "5":
//				if (Member.isLogin == true) {
//					System.out.println("이미 로그인 되어있습니다.");
//					break;
//				}
				System.out.println("======로그인======[이전메뉴 : 0]");
				System.out.println("ID를 입력해주세요.");
				input = sc.nextLine();
				if (input.equals("0")) break;
				System.out.println("password를 입력해주세요.");
				input += " " + sc.nextLine();
				sendToServer("login 5;" + input);
				
				break;
			case "0":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	public void check() throws IOException {
		while (true) {
			Ui.mainUi1();
			input = sc.next();

			if (input.equals("1")) {
				sendToServer("checkAll 1_1");
			}
			if (input.equals("2")) {
				sendToServer("checkCategory 1_2");
			}
			if (input.equals("3")) {
				sendToServer("checkDate 1_3");
			}

			if (input.equals("0"))
				break;
		}
	}

	public void buy() throws IOException {
			Ui.mainUi2();
			input = sc.nextLine();

			if (input.equals("1")) {
				sendToServer("buyAll 2_1"); 
				buyBookClient();
			}
			if (input.equals("2")) {
				System.out.println("책제목을 입력해주세요.");
				input = sc.nextLine();
				sendToServer("buyTitle 2_2;" + input); 	
				buyBookClient();
			}
			if (input.equals("3")) {
				System.out.println("카테고리를 입력해주세요.");
				System.out.println("[문학, 교육, 인문, 경제, 사회, 에세이, 자기계발, 여행, 자연과학]");
				input = sc.nextLine();
				sendToServer("buyCategory 2_3;" + input);
				buyBookClient();				
			}
			if (input.equals("0"))
				return;
		}
	

	public void history() throws IOException {
		sendToServer("history 3");

	}

	public static void main(String[] args) {
		Client init = new Client();
		try {
			init.connect();
			init.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
