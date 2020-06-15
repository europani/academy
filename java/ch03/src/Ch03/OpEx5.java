package Ch03;

public class OpEx5 {

	public static void main(String[] args) {
		System.out.println("6 & 3 =" + (6 & 3));	// 0110 & 0011 = 0010
		System.out.println("6 | 3 =" + (6 | 3)); 	// 0110 | 0011 = 0111
		System.out.println("6 ^ 3 =" + (6 ^ 3)); 	// 0110 ^ 0011 = 0101
		System.out.println("~10 =" + ~10);			// 00001010 -> 11110101
		
		System.out.println(Integer.toBinaryString(6));
		
	}

}
