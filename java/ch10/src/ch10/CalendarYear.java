package ch10;

import java.util.Calendar;

public class CalendarYear {
	static int year = 2020;
	static int month = 0;
	static int START_DAY_OF_WEEK1, START_DAY_OF_WEEK2, START_DAY_OF_WEEK3 = 0;
	static int END_DAY1, END_DAY2, END_DAY3 = 0;
	static int a ,b, c;

	public static void main(String[] args) {
		while (month <= 11) {
			CalendarYear.a = 1; CalendarYear.b = 1; CalendarYear.c = 1;
			Calendar sDay1 = Calendar.getInstance();
			Calendar eDay1 = Calendar.getInstance();
			Calendar sDay2 = Calendar.getInstance();
			Calendar eDay2 = Calendar.getInstance();
			Calendar sDay3 = Calendar.getInstance();
			Calendar eDay3 = Calendar.getInstance();

			sDay1.set(year, month, 1);
			eDay1.set(year, month + 1, 1);
			eDay1.add(Calendar.DATE, -1); // 1월
			sDay2.set(year, month + 1, 1);
			eDay2.set(year, month + 2, 1);
			eDay2.add(Calendar.DATE, -1); // 2월
			sDay3.set(year, month + 2, 1);
			eDay3.set(year, month + 3, 1);
			eDay3.add(Calendar.DATE, -1); // 3월

			START_DAY_OF_WEEK1 = sDay1.get(Calendar.DAY_OF_WEEK);
			END_DAY1 = eDay1.get(Calendar.DATE);
			START_DAY_OF_WEEK2 = sDay2.get(Calendar.DAY_OF_WEEK);
			END_DAY2 = eDay2.get(Calendar.DATE);
			START_DAY_OF_WEEK3 = sDay3.get(Calendar.DAY_OF_WEEK);
			END_DAY3 = eDay3.get(Calendar.DATE);
			int n1 = START_DAY_OF_WEEK1;
			int n2 = START_DAY_OF_WEEK2;
			int n3 = START_DAY_OF_WEEK3;

			System.out.println("       " + year + "년 " + (month + 1) + "월" + "                             " + year
					+ "년 " + (month + 2) + "월" + "                              " + year + "년 " + (month + 3) + "월");
			System.out.println(" SU MO TU WE TH FR SA    SU MO TU WE TH FR SA    SU MO TU WE TH FR SA");

			while (a<= END_DAY1 || b <= END_DAY2 || c <= END_DAY3) {
				if (a == 1) {
					for (int i = 1; i < START_DAY_OF_WEEK1; i++) {
						System.out.print("   ");
					}
				}
				while (a <= END_DAY1) { 
					System.out.print((a < 10) ? "  " + a : " " + a);
					a++; 
					if (n1 % 7 == 0) {
						System.out.print("   ");
						n1++;
						break;
					}
					n1++;
				}
				if (a > END_DAY1) {
					while (n1 % 7 != 0) {
						System.out.print("   ");
						n1++;
					}
					System.out.print("\t");
				}

				if (b == 1) {
					for (int j = 1; j < START_DAY_OF_WEEK2; j++) {
						System.out.print("   ");
					}
				}
				while (b <= END_DAY2) { 
					System.out.print((b < 10) ? "  " + b : " " + b);
					b++; 
					if (n2 % 7 == 0) {
						System.out.print("   ");
						n2++;
						break;
					}
					n2++;
					if (b > END_DAY2) {
						while (n2 % 7 != 0) {
							System.out.print("   ");
							n2++;
						}
						System.out.print("\t");
					}
				}

				if (c == 1) {
					for (int k = 1; k < START_DAY_OF_WEEK3; k++) {
						System.out.print("   ");
					}
				}
				while (c <= END_DAY3) { 
					System.out.print((c < 10) ? "  " + c : " " + c);
					c++; 
					if (n3 % 7 == 0) {
						System.out.print("   ");
						n3++;
						break;
					}
					n3++;
					if (c > END_DAY3) {
						while (n3 % 7 != 0) {
							System.out.print("   ");
							n3++;
						}
						System.out.print("\t");
					}
				}
				System.out.println();
			} // while문
			month +=3;
		}

	}

}
