import java.io.IOException;
import java.util.*;

public class MainMethod {
	Scanner sc = new Scanner(System.in);
	String input;
	TxtToObject t = new TxtToObject();
	WishList w = new WishList(t);
	Member m = new Member();

	public static void main(String[] args) {
		MainMethod m = new MainMethod();
		try {
			m.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init() throws IOException {
		while (true) {
			Ui.mainUi();
			input = sc.nextLine();

			switch (input) {
			case "1": check(); break;
			case "2": buy(); break;
			case "3": history(); break;
			case "4": m.signUp(); break;
			case "5": m.login(); break;
			case "0":
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}

	public void check() {
		while (true) {
			Ui.mainUi1();
			input = sc.next();

			if (input.equals("1")) {
				checkAll();
			}
			if (input.equals("2")) {
				checkCategory();
			}
			if (input.equals("3")) {
				checkDate();
			}

			if (input.equals("0"))
				break;
		}
	}

	void checkAll() {
		t.txtToObject();
	}

	void checkCategory() {
		t.sort(SortType.category);
	}

	void checkDate() {
		t.sort(SortType.idate);
	}

	public void buy() throws IOException {

		if (m.isLogin == false) {
			System.out.println("로그인이 필요합니다.");
		}
		while (m.isLogin == true) {
			Ui.mainUi2();
			input = sc.nextLine();

			if (input.equals("1")) {
				buyAll();
			}
			if (input.equals("2")) {
				buyTitle();
			}
			if (input.equals("3")) {
				buyCategory();
			}
			if (input.equals("0"))
				break;
			w.makeWishList();
		}
	}

	void buyAll() {
		t.printSort("All");
	}

	void buyTitle() {
		t.printSort("Title");
	}

	void buyCategory() {
		t.printSort("Category");
	}

	public void history() {
		w.printWishlist();
		
	}


}
