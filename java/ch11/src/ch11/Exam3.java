package ch11;

import java.util.*;

public class Exam3 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String[] con = {"대한민국", "캐나다", "영국", "스위스"};
		String[] capital = {"서울", "오타와", "런던", "베른"};
		for (int i = 0; i < con.length; i++) {
			map.put(con[i], capital[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("나라이름을 입력하세요[종료:끝]");
			String nation = sc.next();
			if (nation.equals("끝")) {
				break;
			}
			if (map.get(nation) == null) {
				System.out.println("입력한 수도가 없습니다. 등록하시겠습니까?(Y)");
				String input = sc.next();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("수도를 입력하세요.");
					input = sc.next();
					map.put(nation, input);
					continue;
				}
			} else {
				System.out.println(map.get(nation));
			}
		}
		
		for (Map.Entry<String, String> s : map.entrySet()) {
			System.out.println(s);
		}
		for (String k : map.keySet()) {
			System.out.println(k + "=" + map.get(k));
		}
		
	}

}
