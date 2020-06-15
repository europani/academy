package ch11;

import java.util.*;

public class SetEx3 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("ȫ�浿", 10));
		list.add(new Person("ȫ�浿", 10));
		list.add(new Person("ȫ�浿", 30));
		list.add(new Person("������", 10));
		list.add(new Person("������", 16));
		
		Person p1 = new Person("���", 20);
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
		return name.hashCode() + age;	// StringŬ������ hashCode()�̿�
	}

	@Override
	public int compareTo(Person o) {
//		return age-o.age;				// ���̼�(ASC)
		return name.compareTo(o.name);	// �̸��� (StringŬ������ compareTo ���)
	}
	
}
