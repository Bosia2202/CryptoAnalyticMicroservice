package com.cryptomarket.cryptoanalyticmicroservice.services;

import org.springframework.stereotype.Service;

import com.cryptomarket.cryptoanalyticmicroservice.models.VolatilityInfo;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.ShortVolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityTrendStatus;

@Service
public class VolatilityService {

    private ShortVolatilityStatus shortVolatilityStatus;
    private VolatilityStatus volatilityStatus;
    private VolatilityTrendStatus volatilityTrendStatus;

    public VolatilityService(ShortVolatilityStatus shortVolatilityStatus, VolatilityStatus volatilityStatus,
            VolatilityTrendStatus volatilityTrendStatus) {
        this.shortVolatilityStatus = shortVolatilityStatus;
        this.volatilityStatus = volatilityStatus;
        this.volatilityTrendStatus = volatilityTrendStatus;
    }

    public VolatilityInfo getVolatility(float percentChange1h, float percentChange24h, float percentChange7d) {
        return new VolatilityInfo(
                calculateVolatility(percentChange1h, percentChange24h, percentChange7d),
                calculateShortVolatility(percentChange1h),
                analyticTrend(percentChange1h, percentChange24h, percentChange7d));
    }

    private VolatilityStatus calculateVolatility(float percentChange1h, float percentChange24h, float percentChange7d) {
        float averageValue = getAveragePercent(percentChange1h, percentChange24h, percentChange7d);
        if (averageValue > 8) {
            return volatilityStatus.HIGHT;
        }
        if (averageValue > 3) {
            return volatilityStatus.MIDDLE;
        } else {
            return volatilityStatus.LOW;
        }
    }

    private float getAveragePercent(float percentChange1h, float percentChange24h, float percentChange7d) {
        return Math.abs(percentChange1h) + Math.abs(percentChange24h)
                + Math.abs(percentChange7d) / 3;
    }

    private ShortVolatilityStatus calculateShortVolatility(float percentChange1h) {
        if (Math.abs(percentChange1h) > 5) {
            return shortVolatilityStatus.HIGHT;
        }
        return shortVolatilityStatus.MODERATE;
    }

    private VolatilityTrendStatus analyticTrend(float percent_change_1h, float percent_change_24h,
            float percent_change_7d) {
        if (percent_change_1h > 0 && percent_change_24h > 0 && percent_change_7d > 0) {
            return volatilityTrendStatus.UPTREND;
        } else {
            if (percent_change_1h < 0 && percent_change_24h < 0 && percent_change_7d < 0) {
                return volatilityTrendStatus.DOWNTREND;
            } else {
                return volatilityTrendStatus.MIXEDTREND;
            }
        }
    }

}
