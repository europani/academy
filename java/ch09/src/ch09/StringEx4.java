package ch09;

public class StringEx4 {
	
	static String change(String str) {
		str+="456";
		System.out.println("change() s : " + str);
		return str;
	}

	public static void main(String[] args) {
		String str = "ABC";
		String str1 = "ABC";
		System.out.println("main : " + str);
		str = change(str);
		System.out.println("change 이후 main : " + str);
		change(str);
		System.out.println("change 이후 main(재설정X) : " + str);
		
		str = "12345678";
		str = str.substring(3);
		System.out.println(str);
		
		
		}
	
	

}
