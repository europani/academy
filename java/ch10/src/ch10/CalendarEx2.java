package ch10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalendarEx2 {

	public static void main(String[] args) throws ParseException {
		System.out.println("첫번째 날짜를 입력하세요(yyyy-mm-dd)");
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		System.out.println("두번째 날짜를 입력하세요(yyyy-mm-dd)");
		String second = sc.nextLine();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		Date fdate = sf.parse(first);
		Date sdate = sf.parse(second);
		long datecnt = (sdate.getTime() - fdate.getTime())/(60*60*1000*24);
		System.out.printf("%s - %s 일자의 차이 : %d\n", second, first, datecnt);
		
		
	}

}
