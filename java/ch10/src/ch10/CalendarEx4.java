package ch10;

import java.util.Calendar;

public class CalendarEx4 {

	public static void main(String[] args) {
		int year = 2020;
		int month = 5;			//5월
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		Calendar sDay = Calendar.getInstance();			// 시작일
		Calendar eDay = Calendar.getInstance();			// 종료일
		
		sDay.set(year, month-1, 1);
		eDay.set(year, month, 1);
		eDay.add(Calendar.DATE, -1); 			// 마지막날
	
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);		// 시작날 요일
		END_DAY = eDay.get(Calendar.DATE);						// 마지막날 날짜

		System.out.println("      " + year + "년 " + month + "월");
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
