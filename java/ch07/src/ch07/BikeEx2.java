package ch07;

public class BikeEx2 {

	public static void main(String[] args) {
		AutoBike auto1 = new AutoBike(2);
		AutoBike auto2;
		Bike bike;
		
		auto1.power();
		System.out.println(auto1.drive());
		System.out.println("바퀴 " +  auto1.wheel + "개가 굴러간다.");
		System.out.println(auto1.stop());
		bike = auto1;			// 오토캐스팅(자식->부모)
//		bike.power();			// Bike 타입이라 AutoBike의 메서드 실행 X
		System.out.println("===========");
		System.out.println(bike.drive());		// 타입이 부모클래스여도 자식클래스에서 오버라이딩 된 함수 실행
		auto2 = (AutoBike) bike;				
		auto2.power();
		System.out.println(auto2.drive());
		System.out.println(auto2.stop());
	}

}
