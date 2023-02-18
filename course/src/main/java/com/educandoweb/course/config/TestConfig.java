package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepositoy;
import com.educandoweb.course.repositories.UserRepositoy;

@Configuration
@Profile("test")
/*
 * Classe configuração para pefil de teste. Este perfil foi implementado no aplication.properties
 */
public class TestConfig implements CommandLineRunner{

		@Autowired
		private UserRepositoy userRepositoy;
		
		@Autowired
		private OrderRepositoy orderRepositoy;

		@Override	//funciona quase como MAIN
		public void run(String... args) throws Exception {
			
			User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
			User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
			
			Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
			Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
			Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
			
			
			userRepositoy.saveAll(Arrays.asList(u1, u2));
			orderRepositoy.saveAll(Arrays.asList(o1, o2, o3));
			
		}
		
		
		
}
