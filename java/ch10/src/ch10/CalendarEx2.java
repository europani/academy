package ch10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalendarEx2 {

	public static void main(String[] args) throws ParseException {
		System.out.println("ù��° ��¥�� �Է��ϼ���(yyyy-mm-dd)");
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		System.out.println("�ι�° ��¥�� �Է��ϼ���(yyyy-mm-dd)");
		String second = sc.nextLine();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
		Date fdate = sf.parse(first);
		Date sdate = sf.parse(second);
		long datecnt = (sdate.getTime() - fdate.getTime())/(60*60*1000*24);
		System.out.printf("%s - %s ������ ���� : %d\n", second, first, datecnt);
		
		
	}

}
