package ch06;

public class Exercise6_19 {
	public static String change(String str) {
		str += "456";
		
		return str;
		}
	
		public static void main(String[] args)
		{
		String str = "ABC123";
		System.out.println(str);
		change(str);
		System.out.println("After change:"+str);
		}

}
