package ch06;

public class PhoneEx2 {

	public static void main(String[] args) {
		Phone[] parr = new Phone[3];
		for (int i = 0; i < parr.length; i++) {
			parr[i] = new Phone();						// �迭�� ��ü �Ҵ�
			parr[i].no = i + "1234";
		}
		
		for (int i = 0; i < parr.length; i++) {
			System.out.printf("parr[%d] = %s\n", i, parr[i].no);
			parr[i].send((i ==0)? parr[parr.length-1].no : parr[i-1].no);	//���� ��ȣ���� �޽��� ����
		}
	}

}

