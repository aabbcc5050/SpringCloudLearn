package com.example.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope//@RefreshScope会在配置更改时得到特殊处理
@RestController
public class ConfigClientController {

	@Value("{${profile}}")
	private String profile;
	
	@GetMapping("/profile")
	public String hello(){
		return this.profile;
	}
}
