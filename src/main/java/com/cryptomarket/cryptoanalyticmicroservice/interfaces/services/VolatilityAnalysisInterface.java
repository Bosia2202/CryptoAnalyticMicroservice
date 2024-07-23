package com.cryptomarket.cryptoanalyticmicroservice.interfaces.services;

import com.cryptomarket.cryptoanalyticmicroservice.models.VolatilityInfo;

public interface VolatilityAnalysisInterface {
    VolatilityInfo getVolatility(float percentChange1h, float percentChange24h, float percentChange7d);
}
