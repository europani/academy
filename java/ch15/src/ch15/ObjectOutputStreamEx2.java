package ch15;

import java.io.*;

public class ObjectOutputStreamEx2 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("object2.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		User u1 = new User("È«±æµ¿", "1234", 20);
		User u2 = new User("±è»ñ°«", "4567", 30);
		
		oos.writeObject(u1);
		oos.writeObject(u2);
		System.out.println("»ç¿ëÀÚ1 : " + u1);
		System.out.println("»ç¿ëÀÚ2 : " + u2);
	}

}

class UserInfo {
	protected String name;
	protected String password;

	public UserInfo() {}

	public UserInfo(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", password=" + password + "]";
	}
}

class User extends UserInfo implements Serializable {
	private int age;

	public User(String name, String password, int age) {
		super(name,password);
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", password=" + password + "]";
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(name);
		out.writeUTF(password);
		out.defaultWriteObject();
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		name = in.readUTF();
		password = in.readUTF();
		in.defaultReadObject();
	}
	
}
