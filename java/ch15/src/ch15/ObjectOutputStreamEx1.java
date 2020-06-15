package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStreamEx1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("object.ser", true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Customer c1 = new Customer("ȫ�浿", 20);
		Customer c2 = new Customer("���", 30);
		oos.writeObject(c1);
		oos.writeObject(c2);
		System.out.println("��1 : " + c1);
		System.out.println("��2 : " + c2);
	}

}

class Customer implements Serializable {
	private String name;
	private transient int age;
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
}

