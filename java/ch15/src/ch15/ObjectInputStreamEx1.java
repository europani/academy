package ch15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("object.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Customer c1 = (Customer) ois.readObject();
		Customer c2 = (Customer) ois.readObject();
		System.out.println("°í°´1 : " + c1);
		System.out.println("°í°´2 : " + c2);
		
	}

}
