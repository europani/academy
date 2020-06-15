package ch14;

import java.util.function.*;

public class ConstructorReferenceEx {

	public static void main(String[] args) {
		Function<String, Member2> function1 = Member2::new;
		// return new Member("aaa");
		Member2 member1 = function1.apply("angle");
		BiFunction<String, String, Member2> function2 = Member2::new;
		Member2 member2 = function2.apply("�ų���", "angle");
	}

}

class Member2 {
	private String name;
	private String id;
	
	public Member2() {
		System.out.println("Member() ����");
	}
	public Member2(String id) {
		System.out.println("Member(String id) ����");
		this.id = id;
	}
	public Member2(String id, String name) {
		System.out.println("Member(String id, String name) ����");
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
}
