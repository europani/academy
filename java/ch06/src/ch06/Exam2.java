package ch06;

/*Rectangle 객체를 3개 저장할 배열 생성
	0 : 가로10 세로20
	1 : 가로11 세로21
	2 : 가로12 세로22
	각각의 넓이와 둘레 출력
*/
public class Exam2 {

	public static void main(String[] args) {
		Rectangle[] reArr = new Rectangle[3];

		for (int i = 0; i < reArr.length; i++) {
			reArr[i] = new Rectangle();
			reArr[i].width = 10 + i;
			reArr[i].height = 20 + i;
			
			System.out.print("reArr[" + i + "] \t");
			System.out.println("높이 : " + reArr[i].height + ", 길이 : " + reArr[i].width);
			reArr[i].area();
			reArr[i].length();
		}
	}

}
