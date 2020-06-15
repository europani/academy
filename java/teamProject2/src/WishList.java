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
		System.out.println("구매하실 도서명을 입력해주세요.");
		String input = sc.nextLine();
		
		Iterator<Books> it = t.list.iterator();
		while (it.hasNext()) {
			Books b = it.next();
			if (input.equals(b.getTitle())) {
				wishList.add(b);
				cnt++;
				sum += b.getPrice();
				System.out.println("구매리스트에 추가 되었습니다.");
				
				Date today = new Date();
				FileWriter fw = new FileWriter(new File("src/wishList.txt"), true);
				fw.write(b.toTxt(today));
				fw.close();
			}
		}
		if (wishList.isEmpty() == true) {
			System.out.println("재고가 부족합니다.");
		}

	}
	
	void printWishlist() {
		System.out.println("===========================구매리스트===========================");
		for (Books p : wishList) {
			System.out.println(p);
		}
		System.out.println("==============================================================");
		System.out.println("총 갯수 : " + cnt);
		System.out.println("총 금액 : " + sum);
	}
	


}
