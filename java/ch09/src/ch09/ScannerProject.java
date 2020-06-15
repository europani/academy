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
				System.out.println("다시 입력해주세요.");
			}

			switch (num) {
			case 1: menu1(); break;
			case 2: menu2(); break;
			case 3: menu3(); break;
			case 4: menu4(); break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
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
			System.out.println("품목을 입력해주세요(전자제품, 식료품, 의류, 생활용품) [이전메뉴 : 0]");
			Scanner sc2;
			String input = sc.nextLine();
			String list = "";
			switch (input) {
			case "전자제품":
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
				
			case "식료품":
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
				
			case "의류":
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
				
			case "생활용품":
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
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
}

class Ui1 {
	void mainUi() {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 제품현황");
		System.out.println("4. 판매현황");
		System.out.println("0. 종료");
	}

	void mainUi1() {
		System.out.println(">>회원가입 [이전메뉴:0]");
		System.out.println("회원정보를 입력하세요(회원ID, 비밀번호, 이름, 나이, 성별)");
	}

	void mainUi2() {
		System.out.println(">>로그인 [이전메뉴:0]");
		System.out.println("로그인 정보를 입력하세요.(회원ID, 비밀번호)");
	}

	void mainUi3() {
		System.out.println(">>제품현황 [이전메뉴:0]");
		System.out.println("1.제품보기");
		System.out.println("2.제품월별입고리스트");
		System.out.println("3.품목별입고리스트");
		System.out.println("4.제품월별출고리스트");

	}

	void mainUi4() {
		System.out.println(">>판매현황 [이전메뉴:0]");
		System.out.println("1.회원별제품판매현황");
		System.out.println("2.회원별월별판매현황");
	}
}
