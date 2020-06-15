package ch07;

public class SingletonEx {

	public static void main(String[] args) {
//		SingleObject so = new SingleObject();
		SingleObject so1 = SingleObject.getObject(); // =obj
		SingleObject so2 = SingleObject.getObject(); // =obj
		System.out.println(so1 + ", "+ so2);			// 주소 같음 (만들어진 하나의 주소를 가져옴)
		
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1 + ", "+ o2);				// 주소 다름
		
		System.out.println(so1.getValue());
		System.out.println(so2.getValue());
		so1.setValue(500);
		System.out.println(so1.getValue());
		System.out.println(so2.getValue());
		if (so1 == so2) {
			System.out.println("so1과 so2는 같은 객체임");
		}
		
	}

}
class SingleObject {
	private static SingleObject obj = new SingleObject();	// 클래스 내부에서 객체 생성. cuz, private 생성자
	private SingleObject() {}
	private int value =100;
	
	public static SingleObject getObject() {				// 외부에서 접근해 올수 있는 메서드
		return obj;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
