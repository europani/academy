package ch07;

public class Exam1 {

	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		// 1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10,
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.pick());
		System.out.println(deck.pick(0));
	}

}

class SutdaDeck {
	SutdaCard[] card = new SutdaCard[20];

	SutdaDeck() {
		for (int i = 0; i < card.length; i++) {
			card[i] = new SutdaCard((i % 10) + 1, (i == 0 || i == 2 || i == 7) ? true : false);
		}

	}

	void shuffle() {
		for (int i = 0; i < card.length; i++) {
			int a = (int) (Math.random() * card.length);
			int b = (int) (Math.random() * card.length);
			SutdaCard tmp = card[a];
			card[a] = card[b];
			card[b] = tmp;

		}
	}

	SutdaCard pick() { // 임의 카드 한장 반환
		return card[(int) (Math.random() * card.length)];
	}

	SutdaCard pick(int index) { // Index에 해당하는 카드 반환
		return card[index];
	}

	@Override
	public String toString() {
		String result = "";
		for (SutdaCard c : card) {
			result += c.toString() + ", ";
		}
		return result;
	}

}

class SutdaCard {
	int number;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int number, boolean isKwang) {
		this.number = number;
		this.isKwang = isKwang;
	}

	void info() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return number + (isKwang ? "K" : "");
	}

}
