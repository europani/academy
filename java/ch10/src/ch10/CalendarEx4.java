package ch10;

import java.util.Calendar;

public class CalendarEx4 {

	public static void main(String[] args) {
		int year = 2020;
		int month = 5;			//5��
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		Calendar sDay = Calendar.getInstance();			// ������
		Calendar eDay = Calendar.getInstance();			// ������
		
		sDay.set(year, month-1, 1);
		eDay.set(year, month, 1);
		eDay.add(Calendar.DATE, -1); 			// ��������
	
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);		// ���۳� ����
		END_DAY = eDay.get(Calendar.DATE);						// �������� ��¥

		System.out.println("      " + year + "�� " + month + "��");
		System.out.println(" SU MO TU WE TH FR SA");
		
		for (int i = 1; i < START_DAY_OF_WEEK; i++) {
			System.out.print("   ");
		}
		
		for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
			System.out.print((i < 10)? "  " + i :" "+ i);
			if (n % 7 == 0) {
				System.out.println();
			}
		}
	}

}