package ch09;

public class StringEx2 {

	public static void main(String[] args) {
		String s = "ABCDEFGH";
		System.out.println(s.charAt(4));							// E
		System.out.println(s.compareTo("abc"));						// -32
		System.out.println(s.compareToIgnoreCase("abcdefgh"));		// 0
		System.out.println(s.concat("abc"));						// ABCDEFGHabc
		System.out.println(s + "abc");								// ABCDEFGHabc
		System.out.println(s.endsWith("GH"));						// true
		System.out.println(s.startsWith("AB"));						// true
		System.out.println(s.equals("abcdefgh"));					// false
		System.out.println(s.equalsIgnoreCase("abcdefgh"));			// true
		
		s = new String("This is a String");
		System.out.println(s.indexOf('i'));							// 2
		System.out.println(s.indexOf('i', 5));						// 5
		System.out.println(s.indexOf('i', 15));						// -1
		System.out.println(s.lastIndexOf("is"));					// 5
		System.out.println(s.length());								// 16
		System.out.println(s.replace("is", "QR"));					// ThQR QR a String
		
		System.out.println(s.substring(5));							// is a String
		System.out.println(s.substring(5, 13));						// is a Str
		System.out.println(s.toLowerCase());						// THIS IS A STRING
		System.out.println(s.toUpperCase());						// this is a string
		System.out.println("    abc     ".trim());					// abc
				
	}

}
