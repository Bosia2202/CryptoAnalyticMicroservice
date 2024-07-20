package com.cryptomarket.cryptoanalyticmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableKafka
public class CryptoAnalyticMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoAnalyticMicroserviceApplication.class, args);
	}


}