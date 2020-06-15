package ch09;

public class EqualEx1 {

	public static void main(String[] args) {
		Equal e1 = new Equal(10);
		Equal e2 = new Equal(10);

		if (e1 == e2) {
			System.out.println("e1과 e2는 같은 객체임.");
		} else {
			System.out.println("e1과 e2는 다른 객체임.");
		}
		
		if (e1.equals(e2)) {
			System.out.println("e1과 e2는 같은 내용의 객체임");
		} else {
			System.out.println("e1과 e2는 다른 내용의 객체임");
		}
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		if (s1 == s2) {
			System.out.println("s1과 s2는 같은 객체임.");
		} else {
			System.out.println("s1과 s2는 다른 객체임.");
		}
		
		if (s1.equals(s2)) {
			System.out.println("s1과 s2는 같은 내용의 객체임");
		} else {
			System.out.println("s1과 s2는 다른 내용의 객체임");
		}
	}

}

class Equal {
	int value;

	Equal(int value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Equal) {
			Equal e = (Equal) obj;
			return value == e.value;
		} else {
			return false;
		} 
	}
}
