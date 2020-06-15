package ch14_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MappingEx2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/ch14_2/product.txt"));
		// ���� �Ǹ� ���� Map ��ü�� ����
		br.lines()
		.map(s -> {
			String[] str = s.split(",");
			String tmp = "";
			try {
				tmp = str[4];		// ��ǰ ����
			} catch (ArrayIndexOutOfBoundsException e) {
				tmp = "";
			}
			return new Car(Integer.parseInt(str[0]), Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3]), tmp);
			}).filter(s -> s.getCar().equals("�׷���"))
		.forEach(c -> System.out.println(c));

	}

}

class Car {
	private int month;
	private int con;
	private String car;
	private int qty;
	private String remark;
	
	public Car(int month, int con, String car, int qty, String remark) {
		super();
		this.month = month;
		this.con = con;		// 1:�԰�, 2:���, 3:��ǰ
		this.car = car;
		this.qty = qty;
		this.remark = remark;
	}
	
	public int getMonth() {
		return month;
	}
	public int getCon() {
		return con;
	}
	public String getCar() {
		return car;
	}
	public int getQty() {
		return qty;
	}
	public String getRemark() {
		return remark;
	}

	@Override
	public String toString() {
		return "Car [month=" + month + ", con=" + con + ", car=" + car + ", qty=" + qty + ", remark=" + remark + "]";
	}
	
	
}


