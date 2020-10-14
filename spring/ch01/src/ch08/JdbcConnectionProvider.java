package ch08;

import java.sql.Connection;

public class JdbcConnectionProvider implements ConnectionProvider {

	private String driver;
	private String url;
	private String user;
	private String password;

	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void init() {
		System.out.printf("초기화 함[%s, %s, %s, %s]\n", driver, url, user, password);
	}
	
	@Override
	public Connection getConnection() {
		System.out.println("JdbcConnectionProvier: " + url + "연결 생성");
		return null;
	}

}
