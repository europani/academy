package ch11;

import java.util.*;

public class SetEx2 {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person1("È«±æµ¿", 10));
		set.add(new Person1("È«±æµ¿", 10));
		System.out.println(set); // abc´Â StringÅ¬·¡½º·Î toString() ¿À¹ö¶óÀÌµù O

		Person1 p1 = new Person1("±è»ñ°«", 20);
		Person1 p2 = p1;
		set.add(p1);
		set.add(p2);
		System.out.println(set);

	}
}

class Person1 {
	String name;
	int age;

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person1) {
			Person1 p = (Person1) obj;
			return name.equals(p.name) && age == p.age;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

}
