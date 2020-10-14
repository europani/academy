package ch08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources(@PropertySource("classpath:ch08/db.properties"))
public class ConfigOfEnv {
	@Autowired
	private Environment env;
	
	@Bean
	public ConnectionProvider connectionProvider() {
		JdbcConnectionProvider connectionProvider = new JdbcConnectionProvider();
		connectionProvider.setDriver(env.getProperty("db.driver"));
		connectionProvider.setUrl(env.getProperty("db.jdbcUrl"));
		connectionProvider.setUser(env.getProperty("db.user"));
		connectionProvider.setPassword(env.getProperty("db.password"));
		return connectionProvider;
	}
}
