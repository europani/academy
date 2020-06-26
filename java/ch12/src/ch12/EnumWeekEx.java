package ch12;

import java.util.Calendar;

enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumWeekEx {

	public static void main(String[] args) {
		Week today = null;
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
//		System.out.println(Calendar.DAY_OF_WEEK);
//		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		switch (week) {
		case 1: today = Week.SUNDAY; break;
		case 2: today = Week.MONDAY; break;
		case 3: today = Week.TUESDAY; break;
		case 4: today = Week.WEDNESDAY; break;
		case 5: today = Week.THURSDAY; break;
		case 6: today = Week.FRIDAY; break;
		case 7: today = Week.SATURDAY; break;
		}
		System.out.println("���ÿ��� : " + today + ", " + today.ordinal());
		
		if (today == Week.SUNDAY) {
			System.out.println("�Ͽ����� ���ϴ�.");
		} else {
			System.out.println("�ڹ� ���θ� �մϴ�.");
		} 

	}

}