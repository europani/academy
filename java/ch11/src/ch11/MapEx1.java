package ch11;

import java.util.*;

public class MapEx1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] names = {"ȫ�浿", "���", "�̸���", "�Ӳ���", "���"};
		int[] nums = {1234,4567,2350,9870,3456};
		for (int i = 0; i < names.length; i++) {
			map.put(names[i], nums[i]);
		}
		System.out.println(map);
		
		System.out.println("ȫ�浿�� ��ȣ : " + map.get("ȫ�浿"));
		System.out.println("����� ��ȣ : " + map.get("���"));
		System.out.println("�̸����� ��ȣ : " + map.get("�̸���"));
		System.out.println("�Ӳ����� ��ȣ : " + map.get("�Ӳ���"));

		System.out.println("\nKey�� ��ȸ");
		Set<String> key = map.keySet();
		for (String s : key) {
			System.out.println(s);
		}
		
		System.out.println("\nValues�� ��ȸ");
		Collection<Integer> values = map.values();
		for (Integer v : values) {
			System.out.println(v);
		}
		
		System.out.println("\n������ ��ȸ");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		for (Map.Entry<String, Integer> m : entry) {
			System.out.println(m);
		}
				
	}

}
