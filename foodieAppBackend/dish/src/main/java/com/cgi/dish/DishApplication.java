package com.cgi.dish;

import com.cgi.dish.model.Dish;
import com.cgi.dish.repository.DishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DishApplication {

	public static void main(String[] args) {
		SpringApplication.run(DishApplication.class, args);

	}
	/*public CommandLineRunner demo(DishRepository dishRepository){
		return (args -> {
			dishRepository.save(new Dish("245", "hisd","250","hello","url"));
			dishRepository.save(new Dish("21", "sushi","270","hi","urlimage"));
		});
	}*/

}
