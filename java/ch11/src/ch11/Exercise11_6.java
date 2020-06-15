package ch11;

import java.util.*;

class Exercise11_6 {
	static int getGroupCount(TreeSet tset, int from, int to) { // ?????
		Student11 s1 = new Student11("",0,0,from,from,from);
		Student11 s2 = new Student11("",0,0,to,to,to);
		return tset.subSet(s1,s2).size();

	}

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() {
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Student11 && o2 instanceof Student11) {
					Student11 s1 = (Student11) o1;
					Student11 s2 = (Student11) o2;
					return (int) (s1.getAverage() - s2.getAverage());
				} else {
					return -1;
				}
			}
		});
		set.add(new Student11("È«±æµ¿", 1, 1, 100, 100, 100));
		set.add(new Student11("³²±Ã¼º", 1, 2, 90, 70, 80));
		set.add(new Student11("±èÀÚ¹Ù", 1, 3, 80, 80, 90));
		set.add(new Student11("ÀÌÀÚ¹Ù", 1, 4, 70, 90, 70));
		set.add(new Student11("¾ÈÀÚ¹Ù", 1, 5, 60, 100, 80));
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("[60~69] :" + getGroupCount(set, 60, 70));
		System.out.println("[70~79] :" + getGroupCount(set, 70, 80));
		System.out.println("[80~89] :" + getGroupCount(set, 80, 90));
		System.out.println("[90~100] :" + getGroupCount(set, 90, 101));
	}
}

class Student11 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int total;
	int schoolRank;

	Student11(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor+eng+math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage() + ","+schoolRank;
	}

	public int compareTo(Object o) {
		if (o instanceof Student11) {
			Student11 tmp = (Student11) o;
			return name.compareTo(tmp.name);
		} else {
			return -1;
		}
	}
}