package com.kosolart.spring.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ReactiveConfiguration {

	@Bean
	public WebClient getSampleWebClient(){
		ReactorClientHttpConnector reactorClientHttpConnector = new ReactorClientHttpConnector();
		WebClient webClient = WebClient.builder().clientConnector(reactorClientHttpConnector).build();
		return webClient;
	}
}
