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
				System.out.println("�ٽ� �Է����ּ���.");
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
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}
	}

	public void menu1() {
		try {
			int cnt = 0;
			int sum = 0;

			System.out.printf("  ǰ��\t ��ǰ��\t  �԰�¥\t\t ����\t ��ǰ�ڵ�\n");
			sc2 = new Scanner(new File("src/teamProject/productList.txt"));
			while (sc2.hasNextLine()) {
				arr = sc2.nextLine().split(",");
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
				cnt++;
				sum += Integer.valueOf(arr[3]);
			}
			System.out.println("==========================");
			System.out.println("ǰ��� : " + cnt);
			System.out.println("�������� �� : " + sum);
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
		System.out.printf("  ǰ��\t ��ǰ��\t  �԰�¥\t\t ����\t ��ǰ�ڵ�\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("������ǰ")) {
					System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_2() throws FileNotFoundException {
		System.out.printf("  ǰ��\t ��ǰ��\t  �԰�¥\t\t ����\t ��ǰ�ڵ�\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("�м�")) {
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_3() throws FileNotFoundException {
		System.out.printf("  ǰ��\t ��ǰ��\t  �԰�¥\t\t ����\t ��ǰ�ڵ�\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("����")) {
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_4() throws FileNotFoundException {
		System.out.printf("  ǰ��\t ��ǰ��\t  �԰�¥\t\t ����\t ��ǰ�ڵ�\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("�ķ�ǰ")) {
				System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4]);
			}
		}
		System.out.println();
	}

	public void menu2_5() throws FileNotFoundException {
		System.out.printf("  ǰ��\t ��ǰ��\t  �԰�¥\t\t ����\t ��ǰ�ڵ�\n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			if (arr[0].equals("����")) {
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
		System.out.printf(" ��ǰ�� \t  �԰�¥ \n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			System.out.println(arr[1] + "\t" + arr[2]);
		}

	}

	public void menu3_2() throws FileNotFoundException {
		System.out.printf(" ��ǰ�� \t ���� \n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			System.out.println(arr[1] + "\t" + arr[3]);
		}
	}

	public void menu3_3() throws FileNotFoundException {
		System.out.printf(" ��ǰ�� \t ��ǰ�ڵ� \n");
		sc2 = new Scanner(new File("src/teamProject/productList.txt"));
		while (sc2.hasNextLine()) {
			arr = sc2.nextLine().split(",");
			System.out.println(arr[1] + "\t" + arr[4]);
		}
	}
}

class Ui {
	void mainUi() {
		System.out.println("1.�����ǰ����");
		System.out.println("2.ǰ����ǰ����Ʈ");
		System.out.println("3.��ȸ");

	}

	void mainUi2() {
		System.out.println(">>ǰ����ǰ����Ʈ [�����޴�:0]");
		System.out.println("1.������ǰ");
		System.out.println("2.�м�");
		System.out.println("3.����");
		System.out.println("4.�ķ�ǰ");
		System.out.println("5.����");
	}

	void mainUi3() {
		System.out.println(">>��ȸ [�����޴�:0]");
		System.out.println("1.�԰�¥");
		System.out.println("2.����");
		System.out.println("3.��ǰ�ڵ�");
	}
}
