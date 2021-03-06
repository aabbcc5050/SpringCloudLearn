package com.example.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@EnableTurbineStream    //开启turbineStream
@Configuration
public class TurbineStreamConfig {

}
