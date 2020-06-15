package ch12;

public class EnumMethodEx {

	public static void main(String[] args) {
		Week today = Week.SUNDAY;
		String name = today.name();
		System.out.println(name);
	
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		// compareTo()
		Week day1 = Week.MONDAY;	Week day2 = Week.WEDNESDAY;
		int result1 = day1.compareTo(day2);
		int result2 = day2.compareTo(day1);
		System.out.println(result1);
		System.out.println(result2);
		
		// valeOf()
		Week[] days = Week.values();
		for (Week day : days) {
			System.out.println(day.name());
		}
		Week weekDay = Week.valueOf(days[(int) (Math.random()*days.length)].name());
		if (weekDay == Week.SATURDAY || weekDay == Week.SUNDAY) {
			System.out.println(weekDay + "주말 이군요");
		} else {
			System.out.println(weekDay + "평일 이군요");
		}
		
		
	}

}
