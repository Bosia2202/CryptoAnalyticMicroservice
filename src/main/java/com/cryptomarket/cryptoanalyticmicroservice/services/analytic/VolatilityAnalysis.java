package com.cryptomarket.cryptoanalyticmicroservice.services.analytic;

import org.springframework.stereotype.Component;

import com.cryptomarket.cryptoanalyticmicroservice.interfaces.services.VolatilityAnalysisInterface;
import com.cryptomarket.cryptoanalyticmicroservice.models.VolatilityInfo;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.ShortVolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityStatus;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.volatility.VolatilityTrendStatus;

@Component
public class VolatilityAnalysis implements VolatilityAnalysisInterface {

    @Override
    public VolatilityInfo getVolatility(float percentChange1h, float percentChange24h, float percentChange7d) {
        return new VolatilityInfo(
                calculateVolatility(percentChange1h, percentChange24h, percentChange7d),
                calculateShortVolatility(percentChange1h),
                analyticTrend(percentChange1h, percentChange24h, percentChange7d));
    }

    private VolatilityStatus calculateVolatility(float percentChange1h, float percentChange24h, float percentChange7d) {
        float averageValue = getAveragePercent(percentChange1h, percentChange24h, percentChange7d);
        if (averageValue > 8) {
            return VolatilityStatus.HIGHT;
        }
        if (averageValue > 3) {
            return VolatilityStatus.MIDDLE;
        } else {
            return VolatilityStatus.LOW;
        }
    }

    private float getAveragePercent(float percentChange1h, float percentChange24h, float percentChange7d) {
        return Math.abs(percentChange1h) + Math.abs(percentChange24h)
                + Math.abs(percentChange7d) / 3;
    }

    private ShortVolatilityStatus calculateShortVolatility(float percentChange1h) {
        if (Math.abs(percentChange1h) > 5) {
            return ShortVolatilityStatus.HIGHT;
        }
        return ShortVolatilityStatus.MODERATE;
    }

    private VolatilityTrendStatus analyticTrend(float percentChange1h, float percentChange24h,
            float percentChange7d) {
        if (percentChange1h > 0 && percentChange24h > 0 && percentChange7d > 0) {
            return VolatilityTrendStatus.UPTREND;
        } else {
            if (percentChange1h < 0 && percentChange24h < 0 && percentChange7d < 0) {
                return VolatilityTrendStatus.DOWNTREND;
            } else {
                return VolatilityTrendStatus.MIXEDTREND;
            }
        }
    }

}
