package com.kosolart.spring.boot;

import java.util.HashMap;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockingApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BlockingApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("server.port","9090");
		properties.put("server.tomcat.max-threads", "5");
		app.setDefaultProperties(properties);
		app.run(args);
	}
}
