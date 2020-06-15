package ch14_2;


import java.util.Arrays;
import java.util.List;

public class FilterEx4 {

	public static void main(String[] args) {
		List<Member10> list = Arrays.asList(
				new Member10("ȫ�浿", Member10.MALE, 30),
				new Member10("�質��", Member10.FEMALE, 20),
				new Member10("�ſ��", Member10.MALE, 45),
				new Member10("�ڼ���", Member10.FEMALE, 27)
				);
		double ageAvg = list.stream().filter(m -> m.getSex() == Member10.MALE)
				.mapToInt(Member10 :: getAge)
				.average()
				.getAsDouble();
		System.out.println("���� ��� ���� : " + ageAvg);
		
	}

}

class Member10 {
	public static int MALE = 0;
	public static int FEMALE = 1;
	private String name;
	private int sex;
	private int age;
	
	public Member10(String name, int sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}
	
	
	
	
}