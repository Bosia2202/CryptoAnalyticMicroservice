package com.cryptomarket.cryptoanalyticmicroservice.models;

import java.io.Serializable;

import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.ShortVolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityTrendStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VolatilityInfo implements Serializable {
    private VolatilityStatus volatility;
    private ShortVolatilityStatus shortVolatility;
    private VolatilityTrendStatus trend;
}
