package com.thgcode.bandapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BandApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BandApiApplication.class, args);
	}
}
