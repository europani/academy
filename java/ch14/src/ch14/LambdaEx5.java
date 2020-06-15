package ch14;

public class LambdaEx5 {

	public static void main(String[] args) {
		Outer o = new Outer();
		o.method();
	}

}

interface LambdaInterface5 {
	void method();
}

class Outer {
	int iv = 10;		// iv
	void method() {
		int iv = 40;		//lv
		LambdaInterface5 f51 = new LambdaInterface5() {
			int iv = 50;		//lv
			@Override
			public void method() {
				System.out.println(Outer.this.iv);
				System.out.println(this.iv);
				System.out.println(iv);
			}
		}; 
		f51.method();
		System.out.println();
		
		
		LambdaInterface5 f52 = () -> {
//			int iv = 50; // ���� local�ȿ� iv �ߺ� X
//			iv = 50; 	// final�̶� ����
			System.out.println(Outer.this.iv);
			System.out.println(this.iv);
			System.out.println(iv);
		};
		f52.method();
		
	
	}
}
