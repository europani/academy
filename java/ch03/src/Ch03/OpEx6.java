package Ch03;

public class OpEx6 {

	public static void main(String[] args) {
		// 8 : 00001000,	-8 : 11111000
		System.out.println("8 << 2 : " + (8 << 2));		// 00100000
		System.out.println("8 >> 2 : " + (8 >> 2));		// 00000010
		System.out.println("8 >>> 2 : " + (8 >>> 2));	// 00000010
		
		System.out.println("-8 << 2 : " + (-8 << 2));	// 11100000
		System.out.println("-8 >> 2 : " + (-8 >> 2));	// 11111110
		System.out.println("-8 >>> 2 : " + (-8 >>> 2));	// 00111110
	}
	

}
