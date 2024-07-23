package com.cryptomarket.cryptoanalyticmicroservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cryptomarket.cryptoanalyticmicroservice.interfaces.database.SaveCryptocurrencyAnalyticInterface;
import com.cryptomarket.cryptoanalyticmicroservice.interfaces.services.CryptoAnalyticInterface;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service

@NoArgsConstructor
@Slf4j
public class ConsumerService {

  private SaveCryptocurrencyAnalyticInterface hash;
  private CryptoAnalyticInterface cryptoAnalyticService;

  @Autowired
  public ConsumerService(SaveCryptocurrencyAnalyticInterface hash, CryptoAnalyticInterface cryptoAnalyticService) {
    this.hash = hash;
    this.cryptoAnalyticService = cryptoAnalyticService;
  }

  @KafkaListener(topics = "cryptocurrency-prices", groupId = "myGroup",containerFactory = "cryptoBriefInfoKafkaDtoKafkaListenerFactory")
  public void consumer(CryptoBriefInfoKafkaDto data) {
    log.info("message -> " + data.toString());
    hash.refreshCryptocurrencyAnalytic(cryptoAnalyticService.getAnalyticInfo(data));
  }
}
