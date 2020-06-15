package ch14;

import java.util.function.IntBinaryOperator;

public class MethodReferencesEx {

	public static void main(String[] args) {
		IntBinaryOperator operator;
		operator = (x, y) -> Calculator.staticMethod(x, y);
		System.out.println(operator.applyAsInt(1, 2));
		operator = Calculator::staticMethod;
		System.out.println(operator.applyAsInt(1, 2));

		Calculator obj = new Calculator();
		operator = (x, y) -> obj.instanceMethod(x, y);
		System.out.println(operator.applyAsInt(1, 2));
		operator = obj::instanceMethod;
		System.out.println(operator.applyAsInt(1, 2));

	}

}

class Calculator {
	public static int staticMethod(int x, int y) {
		return x + y;
	}

	public int instanceMethod(int x, int y) {
		return x + y;
	}
}
