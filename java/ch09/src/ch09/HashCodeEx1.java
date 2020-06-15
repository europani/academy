package ch09;

public class HashCodeEx1 {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = "abc";
		
		System.out.println(str1 == "abc");						// false (str1 == str3) 
		System.out.println(str1.equals(str2));					// true
		System.out.println(str1.hashCode());					// 96354	
		System.out.println(str2.hashCode());					// 96354
		System.out.println(System.identityHashCode(str1));		// 1392838282
		System.out.println(System.identityHashCode(str2));		// 523429237
		System.out.println();
		
		Value var1 = new Value("abc");
		Value var2 = new Value("abc");
		
		System.out.println(var1.equals(var2));					// false (equals 오버라이딩 X -> var1 == var2)
		System.out.println(var1.hashCode());					// 96354
		System.out.println(var2.hashCode());					// 96354
		System.out.println(System.identityHashCode(var1));		// 804564176
		System.out.println(System.identityHashCode(var2)); 		// 1421795058
	}

}

class Value {
	String value;
	
	public Value(String value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Value) {
			Value v = (Value) obj;
			return value == v.value;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
