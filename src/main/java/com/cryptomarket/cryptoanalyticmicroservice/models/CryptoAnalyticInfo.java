package com.cryptomarket.cryptoanalyticmicroservice.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("CryptoAnalyticInfo")
public class CryptoAnalyticInfo {
    @Id
    private String symbol;
    private String name;
    private OfferAnalysisInfo offerAnalysisInfo;
    private VolatilityInfo volatilityInfo;
    private LocalDateTime date;
}
