package ch09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerProject {
	Scanner sc = new Scanner(System.in);
	private int num;
	private Ui1 ui = new Ui1();

	public static void main(String[] args) {
		ScannerProject init = new ScannerProject();
		init.initial();
	}

	public void initial() {
		while (true) {
			ui.mainUi();
			this.num = sc.nextInt();
			sc.nextLine();

			if (num > 4 || num < 0) {
				System.out.println("�ٽ� �Է����ּ���.");
			}

			switch (num) {
			case 1: menu1(); break;
			case 2: menu2(); break;
			case 3: menu3(); break;
			case 4: menu4(); break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}
	}

	public void menu1() {
		ui.mainUi1();
		while (true) {
			String input = sc.nextLine();
			if (input.equals("0")) {
				return;
			}
		}
	}

	public void menu2() {
		ui.mainUi2();
		while (true) {
			String input = sc.nextLine();
			if (input.equals("0")) {
				return;
			}
		}
	}

	public void menu3() {
		while (true) {
			ui.mainUi3();
			String input = sc.nextLine();
			if (input.equals("3")) {
				menu3_3();
			}
			if (input.equals("0")) {
				return;
			}
		}
	}

	public void menu4() {
		ui.mainUi4();
		String input = sc.nextLine();
		if (input.equals("0")) {
			return;
		}
	}

	public void menu3_3() {
		while (true) {
			System.out.println("ǰ���� �Է����ּ���(������ǰ, �ķ�ǰ, �Ƿ�, ��Ȱ��ǰ) [�����޴� : 0]");
			Scanner sc2;
			String input = sc.nextLine();
			String list = "";
			switch (input) {
			case "������ǰ":
				try {
					sc2 = new Scanner(new File("electronic.txt"));
					while (sc2.hasNextLine()) {
						list += sc2.nextLine() + "\n";
					}
					System.out.println(list);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
				
			case "�ķ�ǰ":
				try {
					sc2 = new Scanner(new File("grocery.txt"));
					while (sc2.hasNextLine()) {
						list += sc2.nextLine()+ "\n";
					}
					System.out.println(list);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
				
			case "�Ƿ�":
				try {
					sc2 = new Scanner(new File("clothes.txt"));
					while (sc2.hasNextLine()) {
						list += sc2.nextLine() + "\n";
					}
					System.out.println(list);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
				
			case "��Ȱ��ǰ":
				try {
					sc2 = new Scanner(new File("household.txt"));
					while (sc2.hasNextLine()) {
						list += sc2.nextLine() + "\n";
					}
					System.out.println(list);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case "0":
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
}

class Ui1 {
	void mainUi() {
		System.out.println("1. ȸ������");
		System.out.println("2. �α���");
		System.out.println("3. ��ǰ��Ȳ");
		System.out.println("4. �Ǹ���Ȳ");
		System.out.println("0. ����");
	}

	void mainUi1() {
		System.out.println(">>ȸ������ [�����޴�:0]");
		System.out.println("ȸ�������� �Է��ϼ���(ȸ��ID, ��й�ȣ, �̸�, ����, ����)");
	}

	void mainUi2() {
		System.out.println(">>�α��� [�����޴�:0]");
		System.out.println("�α��� ������ �Է��ϼ���.(ȸ��ID, ��й�ȣ)");
	}

	void mainUi3() {
		System.out.println(">>��ǰ��Ȳ [�����޴�:0]");
		System.out.println("1.��ǰ����");
		System.out.println("2.��ǰ�����԰���Ʈ");
		System.out.println("3.ǰ���԰���Ʈ");
		System.out.println("4.��ǰ���������Ʈ");

	}

	void mainUi4() {
		System.out.println(">>�Ǹ���Ȳ [�����޴�:0]");
		System.out.println("1.ȸ������ǰ�Ǹ���Ȳ");
		System.out.println("2.ȸ���������Ǹ���Ȳ");
	}
}
