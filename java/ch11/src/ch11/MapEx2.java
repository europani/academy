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
			System.out.println("���̵�� ��й�ȣ�� �Է����ּ���.");
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			System.out.println();
			
			if (map.containsKey(id)) {
				if (map.get(id).equals(password)) {
					System.out.println("�α��� �Ǿ����ϴ�.");
					break;
				} else {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			} else {	
				System.out.println("�������� �ʴ� ���̵��Դϴ�.");
			}
			
		}
		
		
	}

}
