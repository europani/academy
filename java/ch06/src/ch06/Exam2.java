package ch06;

/*Rectangle ��ü�� 3�� ������ �迭 ����
	0 : ����10 ����20
	1 : ����11 ����21
	2 : ����12 ����22
	������ ���̿� �ѷ� ���
*/
public class Exam2 {

	public static void main(String[] args) {
		Rectangle[] reArr = new Rectangle[3];

		for (int i = 0; i < reArr.length; i++) {
			reArr[i] = new Rectangle();
			reArr[i].width = 10 + i;
			reArr[i].height = 20 + i;
			
			System.out.print("reArr[" + i + "] \t");
			System.out.println("���� : " + reArr[i].height + ", ���� : " + reArr[i].width);
			reArr[i].area();
			reArr[i].length();
		}
	}

}
