package com.cryptomarket.cryptoanalyticmicroservice.models;

import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.ShortVolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityTrendStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VolatilityInfo {
    private VolatilityStatus volatility;
    private ShortVolatilityStatus shortVolatility;
    private VolatilityTrendStatus trend;
}
