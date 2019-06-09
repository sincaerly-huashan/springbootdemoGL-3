package com.example.demo.helloController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSayYou {
	
	@Value("${personTest.last-name}")
	private String name;
	
	@RequestMapping("/sayhello")
	public String sayhello() {
		return "sayhello" + name;
	}
	
	

}
