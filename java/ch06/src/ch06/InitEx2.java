package ch06;

public class InitEx2 {
	
	public static void main(String[] args) {
		System.out.println("���θ޼ҵ� ����");
		Block b1 = new Block();
		Block b2 = new Block();
		Block b3 = new Block();
		Block b4 = new Block();
		Block b5 = new Block();
	}
}

class Block {
	
	static int cv = 5;
	int iv = 10;

	static { System.out.println("Ŭ���� �� : " + cv); } // ����ƽ �ʱ�ȭ ��
	{ System.out.println("�ν��Ͻ� �� : " + iv); } // �ν��Ͻ� �ʱ�ȭ ��

	Block() {
		System.out.println("������ ����");
	}
}


