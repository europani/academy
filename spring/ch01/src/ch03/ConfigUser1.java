package ch03;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch02.service.AuthFailLogger;
import ch02.service.AuthenticationService;
import ch02.service.PasswordChangeService;
import ch02.service.User;
import ch02.service.UserRepository;

@Configuration
public class ConfigUser1 {
	
	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}
	
	@Bean
	public User user2() {
		return new User("madvirus", "qwer");
	}
	
	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user2()));
		return userRepo;
	}
	
}
