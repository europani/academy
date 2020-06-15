package ch11;

import java.util.*;

public class Exercise11_7 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student11("이자바", 2, 1, 70, 90, 70));
		list.add(new Student11("안자바", 2, 2, 60, 100, 80));
		list.add(new Student11("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student11("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student11("김자바", 1, 2, 80, 80, 90));
		Collections.sort(list, new BanNoAscending());
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}

class BanNoAscending implements Comparator<Student11> {
	public int compare(Student11 o1, Student11 o2) {
		if (o1.ban == o2.ban) {
			return o1.no - o2.no;
		} else {
			return o1.ban-o2.ban;
		
		}

	}
}