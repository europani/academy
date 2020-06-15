import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WishList {
	Scanner sc = new Scanner(System.in);
	TxtToObject t = new TxtToObject();
	List<Books> wishList = new ArrayList<Books>();
	int cnt = 0, sum = 0; 

	WishList(TxtToObject t) {
		this.t = t;
	}

	void makeWishList() throws IOException {
		System.out.println("�����Ͻ� �������� �Է����ּ���.");
		String input = sc.nextLine();
		
		Iterator<Books> it = t.list.iterator();
		while (it.hasNext()) {
			Books b = it.next();
			if (input.equals(b.getTitle())) {
				wishList.add(b);
				cnt++;
				sum += b.getPrice();
				System.out.println("���Ÿ���Ʈ�� �߰� �Ǿ����ϴ�.");
				
				Date today = new Date();
				FileWriter fw = new FileWriter(new File("src/wishList.txt"), true);
				fw.write(b.toTxt(today));
				fw.close();
			}
		}
		if (wishList.isEmpty() == true) {
			System.out.println("��� �����մϴ�.");
		}

	}
	
	void printWishlist() {
		System.out.println("===========================���Ÿ���Ʈ===========================");
		for (Books p : wishList) {
			System.out.println(p);
		}
		System.out.println("==============================================================");
		System.out.println("�� ���� : " + cnt);
		System.out.println("�� �ݾ� : " + sum);
	}
	


}
