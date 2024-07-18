package com.techgatha.restaurant.MSRestaurantService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsRestaurantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRestaurantServiceApplication.class, args);
	}

}
