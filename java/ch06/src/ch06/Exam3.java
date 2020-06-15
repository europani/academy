package ch06;

/*
	�ν���Ʈ���� : kind, number
	����ƽ���� : width, height
	�޼ҵ� : toString()
	
	card
*/
public class Exam3 {


	public static void main(String[] args) {
		Card card1 = new Card();
		card1.kind = "Heart";
		card1.number = 1;
		System.out.println(card1);
		
		Card card2 = new Card();
		card2.kind = "Spade";
		card2.number = 1;
		System.out.println(card2);
		
		Card.width = 50;
		Card.height = 80;
		System.out.println(card1);
		System.out.println(card2);
	}

}

class Card {
	String kind;
	int number;
	
	static int width;
	static int height;
	
	@Override
	public String toString() {
		return "[kind=" + kind + ", number=" + number + "] " + width + "," +  height;
	}
}
