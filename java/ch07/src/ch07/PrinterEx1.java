package ch07;

public class PrinterEx1 {

	public static void main(String[] args) {
		Printerable able = PrinterManager.getPrinter("INK");
		able.print();
		able = PrinterManager.getPrinter("LAZER");
		able.print();
	}

}

class InkZet implements Printerable {

	@Override
	public void print() {
		System.out.println("잉크젯 Printer에서 출력함");
	}
}

class RazerZet implements Printerable {

	@Override
	public void print() {
		System.out.println("레이저 Printer에서 출력함");
	}
}

class PrinterManager {
	public static Printerable getPrinter(String type) {
		if (type.equals("INK")) {
			return new InkZet();
		} else {
			return new RazerZet();
		}
	}
}