package ch16;
/*
Scanner.nextInt �޼ҵ�� ����� �Է��� ���� ������ ���๮��(����, newline)�� �������� ����
���๮��(����) �������� ���ڷ� �Է� �޽��ϴ�.
���๮��(����)�� ������ ȣ��� Scanner.nextLine( ) �޼ҵ��� �Է����� ó���Ǽ� ������ �߻��մϴ�.
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

	public void connect() {		// ����, ��Ʈ�� ����
		try {
			this.client = new Socket("127.0.0.1", 8000);
			System.out.println(client.getInetAddress() + " Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");

			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendToServer(String menu, String input) {	// input�� ������ ����, �����κ��� �޾ƿ�
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
			scan.nextLine(); // ó�� �Ͽ�����
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
				System.out.println("���α׷��� ���� �Ͽ����ϴ�");
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
		System.out.println("1.ȸ������");
		System.out.println("2.�α���");
		System.out.println("3.��ǰ��Ȳ");
		System.out.println("4.�Ǹ���Ȳ");
		System.out.println("9.exit");
	}

	public void mainUi1() {
		System.out.println(">>1.ȸ������ end(9)");
		System.out.println("ȸ�������� �Է��ϼ���(ȸ��ID,��й�ȣ,�̸�,����,����,�ּ�)");
	}

	public void mainUi2() {
		System.out.println(">>2. �α��� end(9)");
		System.out.println("�α��������� �Է��ϼ���(ȸ��ID,��й�ȣ)");
	}

	public void mainUi3() {
		System.out.println(">>3.��ǰ��Ȳ");
		System.out.println("1.��ǰ����");
		System.out.println("2.��ǰ�����԰���Ʈ");
		System.out.println("3.ǰ���԰���Ʈ");
		System.out.println("4.��ǰ���������Ʈ");
		System.out.println("5.ǰ���԰���Ʈ");
		System.out.println("9..end");
	}

	public void mainUi4() {
		System.out.println(">>4.�Ǹ���Ȳ");
		System.out.println("1.ȸ������ǰ�Ǹ���Ȳ");
		System.out.println("2.ȸ���������Ǹ���Ȳ");
		System.out.println("9..end");
	}
}
