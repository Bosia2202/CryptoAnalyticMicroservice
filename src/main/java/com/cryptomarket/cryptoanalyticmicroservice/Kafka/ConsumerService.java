package com.cryptomarket.cryptoanalyticmicroservice.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(topics = "cryptocurrency-prices", groupId = "myGroup")
    public void consumer(List<CryptoBriefInfoKafkaDto> cryptoBriefInfoKafkaDtos) {
      log.info("consumer -> " + cryptoBriefInfoKafkaDtos.toString());
    }
}
