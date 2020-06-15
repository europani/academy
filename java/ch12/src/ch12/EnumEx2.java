package ch12;

enum Direction1 {
	
	EAST(1, ">"), SOUTH(2, "¡ý"), WEST(3, "<"), NORTH(4, "¡ý"); 
	
	private static final Direction1[] DIR_ARR = Direction1.values() ;
	private final int value;
	private final String symbol;
	
	Direction1(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}
	
	int getValue() {
		return value;
	}
	String getSymbol() {
		return symbol;
	}
			
	public static Direction1 of(int dir) throws IllegalAccessException {
		if (dir <1 || dir > 4) {
			throw new IllegalAccessException("Invalid Value : " + dir);
		}
		return DIR_ARR[dir-1];
	}
	
	public Direction1 rotate(int num) {
		num = num% 4;
		if (num < 0) {
			num += 4;
		}
		return DIR_ARR[(value-1+num) % 4];
	}
	
	@Override
	public String toString() {
		return name() + getSymbol();
	}
}

public class EnumEx2 {

	public static void main(String[] args) throws IllegalAccessException {
		for (Direction1	d : Direction1.values()) {
			System.out.printf("%s=%d%n", d.name(), d.getValue());
		}
		
		Direction1 d1 = Direction1.EAST;
		Direction1 d2 = Direction1.of(1);
		
		System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
		System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
		System.out.println();
		
		System.out.println(Direction1.EAST.rotate(1));
		System.out.println(Direction1.EAST.rotate(2));
		System.out.println(Direction1.EAST.rotate(-1));
		System.out.println(Direction1.EAST.rotate(-2));
		
	}

}
