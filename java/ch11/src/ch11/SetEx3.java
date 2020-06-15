package ch11;

import java.util.*;

public class SetEx3 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("È«±æµ¿", 10));
		list.add(new Person("È«±æµ¿", 10));
		list.add(new Person("È«±æµ¿", 30));
		list.add(new Person("ÀÌÁ¤¹Î", 10));
		list.add(new Person("±èÀ±¹Î", 16));
		
		Person p1 = new Person("±è»ñ°«", 20);
		list.add(p1);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
				
	}
}

class Person implements Comparable<Person> {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + ":" + age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return name.equals(p.name) && age == p.age;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;	// StringÅ¬·¡½ºÀÇ hashCode()ÀÌ¿ë
	}

	@Override
	public int compareTo(Person o) {
//		return age-o.age;				// ³ªÀÌ¼ø(ASC)
		return name.compareTo(o.name);	// ÀÌ¸§¼ø (StringÅ¬·¡½ºÀÇ compareTo »ç¿ë)
	}
	
}
