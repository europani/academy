package ch11;

import java.util.*;

public class ListEx2 {

	public static void main(String[] args) {
		List<Double> list = new ArrayList<Double>();
		list.add(0.3);
		list.add(Math.PI);
		list.add(5.0);
		for (Double d : list) {
			System.out.println(d);
		}
		
		double num = 5.0;
		int index = list.indexOf(num);
		if (index>=0) {
			System.out.println(num + "�� ��ġ : " + index);
		} else {
			System.out.println(num + "�� list�� �����ϴ�.");
		}
		
		num = 0.3;
		System.out.println(list.indexOf(num));
		System.out.println(list.indexOf(5.0));
		if (list.contains(num)) {
			list.remove(num);
			System.out.println(num + "�� ������");
		}
		System.out.println(list.indexOf(num));
		System.out.println(list.indexOf(5.0));
	}
}
