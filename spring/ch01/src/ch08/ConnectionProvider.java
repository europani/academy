package ch08;

import java.sql.Connection;

public interface ConnectionProvider {

	public Connection getConnection();
}
