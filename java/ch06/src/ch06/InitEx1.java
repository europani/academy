package ch06;

public class InitEx1 {

	static int cv;
	int iv;

	InitEx1() {
		System.out.println("5. ������ ȣ��");
	}
	
	static {	//Ŭ���� �ʱ�ȭ��
		cv = (int) (Math.random()*100);
		System.out.println("1. Ŭ���� �ʱ�ȭ ��");
		// iv = (int) (Math.random()*100);
	}
	{			//�ν��Ͻ� �ʱ�ȭ��
		iv = (int) (Math.random()*100);
		System.out.println("4. �ν��Ͻ� �ʱ�ȭ ��");
	}
	
	public static void main(String[] args) {
		System.out.println("2. main�޼ҵ� ����");
		System.out.println("3-1. main init1 ��ü ����");
		InitEx1 init1 = new InitEx1();
		System.out.println("3-2. main init2 ��ü ����");
		InitEx1 init2 = new InitEx1();
		
	}

}
