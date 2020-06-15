package ch14_2;

import java.util.*;

public class ListStreamEx2 {

	public static void main(String[] args) {
		List<Student10> studentList = Arrays.asList(
				new Student10("ȫ�浿", 10),
				new Student10("���ڹ�", 20),
				new Student10("���ֿ�", 30)
		);
		
		double avg = studentList.stream()			// �������� ��Ʈ��
				.mapToInt(s -> s.getScore())		// �߰� ó��
				.average()							// ���� ó��
				.getAsDouble();						// ��ڽ�(Wrapper -> �⺻)
		
		System.out.println("��� ���� : " + avg);
	}

}
