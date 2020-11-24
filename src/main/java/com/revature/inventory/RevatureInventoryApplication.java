package com.revature.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "rss-inventory-service")
@EnableDiscoveryClient
public class RevatureInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevatureInventoryApplication.class, args);

		System.out.println("Hello, world!");

	}

}
