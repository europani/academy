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
		System.out.println("��ũ�� Printer���� �����");
	}
}

class RazerZet implements Printerable {

	@Override
	public void print() {
		System.out.println("������ Printer���� �����");
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