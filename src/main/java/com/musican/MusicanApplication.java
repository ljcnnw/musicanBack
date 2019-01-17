package com.musican;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.musican.*.dao")
@EnableScheduling
@EnableEurekaClient
public class MusicanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicanApplication.class, args);
	}
}
