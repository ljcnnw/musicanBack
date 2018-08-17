package com.musican;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.musican.*.dao")
public class MusicanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicanApplication.class, args);
	}
}
