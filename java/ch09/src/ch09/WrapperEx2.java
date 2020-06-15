package ch09;

public class WrapperEx2 {

	public static void main(String[] args) {
		int is = Integer.parseInt("123");
		System.out.println(is);
		is = Integer.parseInt("123", 8);
		System.out.println(is);
		is = Integer.parseInt("123", 16);
		System.out.println(is);
		System.out.println();
		
		float f = Float.parseFloat("123.45");
		System.out.println(f);
		f = Float.parseFloat("123.45f");
		System.out.println(f);
		System.out.println();
		
		double d = Double.parseDouble("123.45");
		System.out.println(d);
		System.out.println();
		
		System.out.println(Integer.toBinaryString(500));
		System.out.println(Integer.toOctalString(500));
		System.out.println(Integer.toHexString(500));
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toHexString(10));
		
		
	}

}
