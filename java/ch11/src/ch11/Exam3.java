package ch11;

import java.util.*;

public class Exam3 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		String[] con = {"���ѹα�", "ĳ����", "����", "������"};
		String[] capital = {"����", "��Ÿ��", "����", "����"};
		for (int i = 0; i < con.length; i++) {
			map.put(con[i], capital[i]);
		}
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("�����̸��� �Է��ϼ���[����:��]");
			String nation = sc.next();
			if (nation.equals("��")) {
				break;
			}
			if (map.get(nation) == null) {
				System.out.println("�Է��� ������ �����ϴ�. ����Ͻðڽ��ϱ�?(Y)");
				String input = sc.next();
				if (input.equalsIgnoreCase("Y")) {
					System.out.println("������ �Է��ϼ���.");
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
