package ch16;
/*
Scanner.nextInt 메소드는 사용자 입력의 가장 마지막 개행문자(엔터, newline)를 제거하지 않음
개행문자(엔터) 전까지만 숫자로 입력 받습니다.
개행문자(엔터)는 다음에 호출된 Scanner.nextLine( ) 메소드의 입력으로 처리되서 문제가 발생합니다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class DataClient { 
	private Scanner scan = new Scanner(System.in);
	private int menuNumber;
	private UiClass ui = new UiClass();
	Socket client;

	PrintWriter out;
	BufferedReader in;

	public static void main(String[] args) {
		DataClient init = new DataClient();
		init.connect();
		init.initial();
	}

	public void connect() {		// 소켓, 스트림 연결
		try {
			this.client = new Socket("127.0.0.1", 8000);
			System.out.println(client.getInetAddress() + " 클라이언트가 연결되었습니다.");

			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendToServer(String menu, String input) {	// input을 서버로 전송, 서버로부터 받아옴
		out.println(menu + ":" + input);
		out.flush();
		try {
			String line = in.readLine();
			line = line.replace(";", "\n");
			System.out.println("server echo : \n" + line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initial() {
		while (true) {
			ui.mainUi();
			this.menuNumber = scan.nextInt();
			scan.nextLine(); // 처리 하여야함
			switch (this.menuNumber) {
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 4:
				menu4();
				break;
			case 9: {
				System.out.println("프로그램이 종료 하였습니다");
				System.exit(0);
			}
			}
		}
	}

	public void menu1() {
		ui.mainUi1();
		while (true) {
			String input = scan.nextLine();
			if (input.equals("9"))
				return;
			
			sendToServer("menu1", input);
		}
	}


	public void menu2() {
		ui.mainUi2();
		while (true) {
			String input = scan.nextLine();
			if (input.equals("9"))
				return;
			
			sendToServer("menu2", input);
		}
	}

	public void menu3() {
		ui.mainUi3();
		while (true) {
			String input = scan.nextLine();
			switch (input) {
			case "1":
				sendToServer("menu31", input);
				break;
			case "2":

				break;
			case "3":
				readTxt();
				break;
			case "4":
				menu4();
				break;

			}

			if (input.equals("9"))
				return;
		}
	}

	public void menu4() {
		ui.mainUi4();
		while (true) {
			String input = scan.nextLine();
			if (input.equals("9"))
				return;
		}
	}

	public void readTxt() {
		System.out.println("readtxt");
	}
}

class UiClass {
	public void mainUi() {
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.제품현황");
		System.out.println("4.판매현황");
		System.out.println("9.exit");
	}

	public void mainUi1() {
		System.out.println(">>1.회원가입 end(9)");
		System.out.println("회원정보를 입력하세요(회원ID,비밀번호,이름,나이,성별,주소)");
	}

	public void mainUi2() {
		System.out.println(">>2. 로그인 end(9)");
		System.out.println("로그인정보를 입력하세요(회원ID,비밀번호)");
	}

	public void mainUi3() {
		System.out.println(">>3.제품현황");
		System.out.println("1.제품보기");
		System.out.println("2.제품월별입고리스트");
		System.out.println("3.품목별입고리스트");
		System.out.println("4.제품월별출고리스트");
		System.out.println("5.품목별입고리스트");
		System.out.println("9..end");
	}

	public void mainUi4() {
		System.out.println(">>4.판매현황");
		System.out.println("1.회원별제품판매현황");
		System.out.println("2.회원별월별판매현황");
		System.out.println("9..end");
	}
}
