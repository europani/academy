package ch06;

public class PhoneEx1 {

	public static void main(String[] args) {
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		
		phone1.color = "black";
		phone1.power = true;
		phone1.no = "01012345678";
		
		phone1.power();
		System.out.println("�� : " + phone1.color + ", ���� : " + phone1.power + ", ��ȣ : " + phone1.no);
		phone1.send("01022223333");
		phone1.receive("01022223333");
		
		phone2.color = "white";
		phone2.power = false;
		phone2.no = "01056781234";
		
		phone2.power();
		System.out.println("�� : " + phone2.color + ", ���� : " + phone2.power + ", ��ȣ : " + phone2.no);
		phone2.send("01022223333");
		phone2.receive("01022223333");
		
		phone2 = phone1;
		System.out.println("�� : " + phone2.color + ", ���� : " + phone2.power + ", ��ȣ : " + phone2.no);
		
		
	}

}

class Phone {
	boolean power;
	String color;
	String no;
	
	void power() {
		power = !power;
	}
	
	void send(String no) {
		System.out.println("�޽��� ���� ��(to : " + no + ")");
	}
	void receive(String no) {
		System.out.println(no + "�κ��� ����");
	}
}
