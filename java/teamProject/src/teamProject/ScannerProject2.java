package teamProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerProject2 {
	Scanner sc = new Scanner(System.in);
	Scanner sc2;
	private int num;
	private Ui ui = new Ui();
	String[] arr;

	public static void main(String[] args) {
		ScannerProject2 init = new ScannerProject2();
		try {
			init.initial();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void initial() throws FileNotFoundException {
		while (true) {
			ui.mainUi();
			this.num = sc.nextInt();
			sc.nextLine();

			if (num > 3 || num < 0) {
				System.out.println("다시 입력해주세요.");
			}

			switch (num) {
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}

	public void menu1() {
		try {
			int cnt = 0;
			int sum = 0;

			System.out.printf("  품목\t 제품명\t  입고날짜\t\t 수량\t 제품코드\n");
			sc2 = new Scanner(new File("src/teamProject/productList.txt"));
			while (sc2.hasNextLine()) {
				arr = sc2.nextLine().split(",");
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
				cnt++;
				sum += Integer.valueOf(arr[3]);
			}
			System.out.println("==========================");
			System.out.println("품목수 : " + cnt);
			System.out.println("모든수량의 합 : " + sum);
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	public void menu2() throws FileNotFoundException {
		while (true) {
			ui.mainUi2();
			String input = sc.nextLine();
			if (input.equals("1")) {
				menu2_1();
			}
			if (input.equals("2")) {
				menu2_2();
			}
			if (input.equals("3")) {
				menu2_3();
			}
			if (input.equals("4")) {
				menu2_4();
			}
			if (input.equals("5")) {
				menu2_5();
			}
			if (input.equals("0")) {
				return;
			}
		}
	}

	void menu2_1() throws FileNotFoundException {
		System.out.printf("  품목\t 제품명\t  입고날짜\t\t 수량\t 제품코드\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("전자제품")) {
					System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_2() throws FileNotFoundException {
		System.out.printf("  품목\t 제품명\t  입고날짜\t\t 수량\t 제품코드\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("패션")) {
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_3() throws FileNotFoundException {
		System.out.printf("  품목\t 제품명\t  입고날짜\t\t 수량\t 제품코드\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("도서")) {
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_4() throws FileNotFoundException {
		System.out.printf("  품목\t 제품명\t  입고날짜\t\t 수량\t 제품코드\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("식료품")) {
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_5() throws FileNotFoundException {
		System.out.printf("  품목\t 제품명\t  입고날짜\t\t 수량\t 제품코드\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("가구")) {
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu3() throws FileNotFoundException {
		while (true) {
			ui.mainUi3();
			String input = sc.nextLine();
			if (input.equals("1")) {
				menu3_1();
			}
			if (input.equals("2")) {
				menu3_2();
			}
			if (input.equals("3")) {
				menu3_3();
			}
			if (input.equals("0")) {
				return;
			}
		}
	}

	public void menu3_1() throws FileNotFoundException {
		System.out.printf(" 제품명 \t  입고날짜 \n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			System.out.println(arr[1] + "\t" + arr[2]);
		}

	}

	public void menu3_2() throws FileNotFoundException {
		System.out.printf(" 제품명 \t 수량 \n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			System.out.println(arr[1] + "\t" + arr[3]);
		}
	}

	public void menu3_3() throws FileNotFoundException {
		System.out.printf(" 제품명 \t 제품코드 \n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			System.out.println(arr[1] + "\t" + arr[4]);
		}
	}
}

class Ui {
	void mainUi() {
		System.out.println("1.모든제품보기");
		System.out.println("2.품목별제품리스트");
		System.out.println("3.조회");

	}

	void mainUi2() {
		System.out.println(">>품목별제품리스트 [이전메뉴:0]");
		System.out.println("1.전자제품");
		System.out.println("2.패션");
		System.out.println("3.도서");
		System.out.println("4.식료품");
		System.out.println("5.가구");
	}

	void mainUi3() {
		System.out.println(">>조회 [이전메뉴:0]");
		System.out.println("1.입고날짜");
		System.out.println("2.수량");
		System.out.println("3.제품코드");
	}
}
