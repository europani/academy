package ch15;

import java.util.Date;

public class PrintStreamEx2 {

	public static void main(String[] args) {
		System.out.printf("%c%n", 'A');
		System.out.printf("%5c%n", 'A');		// ������ ����
		System.out.printf("%-5c%n", 'A');		// ���� ����
		
		System.out.printf("%d%n", 12345);
		System.out.printf("%,d%n", 12345);		// 3�ڸ� ,
		System.out.printf("%10d%n", 12345);		
		System.out.printf("%010d%n", 12345);		// ���ڸ� 0ä���
		System.out.printf("%-10d%n", 12345);	
		System.out.printf("%,10d%n", 12345);
		System.out.printf("%-,10d%n", 12345);
		System.out.printf("%,010d%n", 12345);
		
		System.out.printf("%o%n", 12345);		// 8����
		System.out.printf("%x%n", 255);		// 16���� �ҹ���ǥ��
		System.out.printf("%X%n", 255);		// 16���� �빮��ǥ��
		
		System.out.printf("%f%n", 12345.12345);
		System.out.printf("%.2f%n", 12345.12345);
		System.out.printf("%10.2f%n", 12345.12345);		// �� 10�ڸ�, �Ҽ��� 2�ڸ�
		System.out.printf("%,10.2f%n", 12345.12345);
		System.out.printf("%-,10.2f%n", 12345.12345);
		System.out.printf("%,010.2f%n", 12345.12345);
		
		System.out.printf("%e%n", 12345.12345);	 // ����
		System.out.printf("%g%n", 12345.12345);	// �ٻ� �Ǽ�
		
		System.out.printf("%b != %b%n", true, false);
		System.out.printf("(2>3) == %b%n", (2>3));
		
		System.out.printf("%s�� %s�̴�.%n", "���", "����");
		System.out.printf("%10s�� %10s�̴�.%n", "���", "����");
		System.out.printf("%-10s�� %-10s�̴�.%n", "���", "����");
		System.out.printf("%10.1s�� %10.1s�̴�.%n", "12345", "12345");		// �� 10�ڸ��� 1�ڸ��� ���̱�
		
		Date d = new Date();
		System.out.printf("%tY�� %tm�� %td�� �Դϴ�.%n", d, d, d);
		System.out.printf("%tH�� %tM�� %tS�� �Դϴ�.%n", d, d, d);
		System.out.printf("������ %1$tH�� %1$tM�� %1$tS�� �Դϴ�.%n", d, d, d);
	}

}
