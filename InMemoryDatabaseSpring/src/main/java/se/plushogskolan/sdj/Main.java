package se.plushogskolan.sdj;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.plushogskolan.sdj.model.User;
import se.plushogskolan.sdj.service.UserService;

public class Main {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.plushogskolan.sdj");
			context.refresh();

			UserService userService = context.getBean(UserService.class);

			for (int i = 0; i < 15; i++) {
				String firstname = RandomStringUtils.randomAlphabetic(5);
				String lastname = RandomStringUtils.randomAlphabetic(5);
				String username = RandomStringUtils.randomAlphabetic(11);
				User user = new User(firstname, lastname, username);
				userService.createUser(user);
			}

			userService.getAllUsers().forEach(System.out::println);

		}
	}
}
