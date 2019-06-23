package com.kosolart.spring.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/")
public class SampleReactiveController {
	@Autowired
	private WebClient webClient;

	@GetMapping("greeting")
	@ResponseBody
	public Mono<String> saySlowHello(){
		System.out.println("Retrieve Greeting Request");
//		Mono<String> stringMono = webClient.get().uri("localhost:9090/greeting").exchange()
//				.flatMap(clientResponse -> clientResponse.bodyToMono(String.class));
		return slothGreeting();
	}

	private Mono<String> slothGreeting() {
		Mono<String> greetingMono = Mono.fromCallable(() -> {
			Thread.sleep(5000);
			return "Sloth Greeting";
		});

		return greetingMono;
	}

}
