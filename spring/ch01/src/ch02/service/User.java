package ch02.service;

public class User {
	private String id;
	private String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}

	public boolean matchPassword(String inputPasswd) {
		return password.equals(inputPasswd);
	}

	public void changePassword(String beforePw, String afterPw) {
		if (!matchPassword(beforePw)) {
			throw new IllegalArgumentException("illegal password");
		}
		password = afterPw;
		System.out.println("passwd 변경 : " + this);
	}
	
	
}
