package com.cryptomarket.cryptoanalyticmicroservice.kafka;

import lombok.Data;
import java.io.Serializable;

@Data
public class CryptoBriefInfoKafkaDto implements Serializable {
    private final String symbol;
    private final String name;
    private final double currentPrice;
    private final float percentChange1h;
    private final float percentChange24h;
    private final float percentChange7d;
    private final double circulatingSupply;
    private final double totalSupply;
    private final double maxSupply;
}
