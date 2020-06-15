package ch11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("spring", "12");	map.put("summer", "34");
		map.put("fall", "56");		map.put("winter", "78");
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			System.out.println();
			
			if (map.containsKey(id)) {
				if (map.get(id).equals(password)) {
					System.out.println("로그인 되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {	
				System.out.println("존재하지 않는 아이디입니다.");
			}
			
		}
		
		
	}

}
