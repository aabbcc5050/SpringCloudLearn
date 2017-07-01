package com.example.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String index() throws InterruptedException{
		ServiceInstance instance=client.getLocalServiceInstance();
		//让处理线程等待几秒钟
		int sleepTime=new Random().nextInt(3000);
		logger.info("sleepTime : [{}]",sleepTime);
		Thread.sleep(sleepTime);
		logger.info("/hello,host:[{}],service_id:[{}]",instance.getHost(),instance.getServiceId());
		return "Hello World";
	}
}
