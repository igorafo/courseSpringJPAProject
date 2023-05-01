package com.example.springProject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.springProject.entities.Category;
import com.example.springProject.entities.Order;
import com.example.springProject.entities.User;
import com.example.springProject.entities.enums.OrderStatus;
import com.example.springProject.repositories.CategoryRepository;
import com.example.springProject.repositories.OrderRepository;
import com.example.springProject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Lebron James", "lebron@goat.com", "988888888", "123456");
		User u2 = new User(null, "Don Toliver", "don@lovesick.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2023-04-29T19:53:07Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2023-05-01T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-04-25T15:21:22Z"), OrderStatus.SHIPPED, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	} 
	
}
