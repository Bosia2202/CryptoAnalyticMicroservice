package com.cryptomarket.cryptoanalyticmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.EventListener;

@SpringBootApplication
@EnableKafka
public class CryptoAnalyticMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoAnalyticMicroserviceApplication.class, args);
	}


}
