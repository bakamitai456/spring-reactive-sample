package com.kosolart.spring.test;

import java.time.Clock;
import java.util.Date;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TestLoadApplication implements CommandLineRunner {
	private static Long startApplicationTime = Clock.systemUTC().millis();

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TestLoadApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start Process At " + new Date(startApplicationTime).toString());
		for (int i = 0; i<=200; i++) {
			Thread thread = new Thread(() -> {
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/greeting", HttpMethod.GET, null, String.class);
				System.out.println("Retrieve response at " + new Date(Clock.systemUTC().millis()).toString());
			});

			thread.setName("Test Runner");
			thread.start();
		}
	}
}
