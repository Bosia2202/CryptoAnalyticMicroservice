package com.cryptomarket.cryptoanalyticmicroservice.interfaces.services;

import com.cryptomarket.cryptoanalyticmicroservice.kafka.CryptoBriefInfoKafkaDto;
import com.cryptomarket.cryptoanalyticmicroservice.models.CryptoAnalyticInfo;

public interface CryptoAnalyticInterface {
    CryptoAnalyticInfo getAnalyticInfo(CryptoBriefInfoKafkaDto data);
}
