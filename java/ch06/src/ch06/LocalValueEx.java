package ch06;

public class LocalValueEx {

	public static void main(String[] args) {
		int num = 200;
		boolean b = true;
		if(b) num = 100;
		System.out.println(num);
		
		String grade = "";
		int score = 80;
		switch (score/10) {
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";
		}
		System.out.println("¼ºÀû : " + grade);
		
	}

}
