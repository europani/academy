package ch14_2;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductGroup {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("src/ch14_2/product.txt"));
		// 월별 판매 수량 Map 객체로 생성
		Stream<Car> car = br.lines()
		.map(s -> {
			String[] str = s.split(",");
			String tmp = "";
			try {
				tmp = str[4];		// 반품 사유
			} catch (ArrayIndexOutOfBoundsException e) {
				tmp = "";
			}
			return new Car(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]), tmp);
			});
		
//		Map<Integer, List<Car>> map = car.collect(Collectors.groupingBy(s -> s.getMonth()));
//		for (Map.Entry<Integer, List<Car>> e : map.entrySet()) {
//			System.out.println(e.getKey() + "월");
//			for (Car c : e.getValue()) {
//				System.out.println(c);
//			}
//		}
		
		// 월별 건수
//		Map<Integer, Long> map2 = car.collect(Collectors.groupingBy(Car::getMonth, Collectors.counting()));
//		for (Map.Entry<Integer, Long> e : map2.entrySet()) {
//			System.out.println(e.getKey() + "월 : " + e.getValue() + "건");
//		}
		
		// 월별 생산수량
//		Map<Integer, Integer> map3 = car.filter(s -> s.getCon() == 1)
//				.collect(Collectors.groupingBy(s -> s.getMonth(), Collectors.summingInt(Car::getQty)));
//		for (Entry<Integer, Integer> e : map3.entrySet()) {
//			System.out.println(e.getKey() + "월 : " + e.getValue() + "대 생산");
//		}
		
		// 품목별 반품수량
		Map<String, Integer> map4 = car.filter(s -> s.getCon() == 3)
				.collect(Collectors.groupingBy(s -> s.getCar(),Collectors.summingInt(Car::getQty)));
		for (Entry<String, Integer> e : map4.entrySet()) {
			System.out.println(e.getKey() + " : " +e.getValue() + "대");
		}
		
	}

}
