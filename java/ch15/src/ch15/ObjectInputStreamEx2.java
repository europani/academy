package ch15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("object2.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		User c1 = (User) ois.readObject();
		User c2 = (User) ois.readObject();
		System.out.println(c1);
		System.out.println(c2);
		
	}

}
