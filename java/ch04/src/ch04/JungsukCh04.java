package ch04;

public class JungsukCh04 {

	public static void main(String[] args) {
//	[4-4]
		int i = 1;
		int sum = 0;
		
		while (sum <100) {
			if (i%2 == 0) {
				sum -= i;
			} else {
				sum += i;
			}
			i++;
			
		}
		System.out.println(sum);
		System.out.println(i);
	
//	[4-5]
		i=0;
		int j=0;
		
		while (i <= 10) {
			j=0;
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			i++;
			System.out.println();
		}
		
// 	[4-6]
		i=0;
		j=0;
		
		for (i = 1; i <= 6; i++) {
			for (j = 1; j <= 6; j++) {
				if ((i+j == 6)) {
					System.out.println("[" + i + " , " + j + "]");
				} else continue;
				
			}
		}
		System.out.println();
		
//	[4-7]
		int value = (int)(Math.random()*6)+1;
		System.out.println(value);
		System.out.println();
		
//	[4-9]
		String str = "12345";
		sum = 0;
		for(i=0; i < str.length(); i++) {
			sum += (str.charAt(i)-48);
		}
		System.out.println(sum);
		System.out.println();
		
//	[4-13]
		String value2 = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		
		for (i = 0; i < value2.length(); i++) {
			ch = value2.charAt(i);
			if (!('0' <= ch && ch <= '9')) {
				isNumber = !isNumber;
			} 
		}
		
		if (isNumber) {
			System.out.println(value2+"는 숫자입니다. ");
		} else {
			System.out.println(value2+"는 숫자가 아닙니다. ");
		}
		
	}
}
