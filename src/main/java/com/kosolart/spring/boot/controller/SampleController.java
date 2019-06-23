package com.kosolart.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@GetMapping("greeting")
	@ResponseBody
	public String sayHello() throws InterruptedException {
		Thread.sleep(10000);

		return "hello world";
	}

}
