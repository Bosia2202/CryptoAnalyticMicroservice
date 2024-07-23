package com.cryptomarket.cryptoanalyticmicroservice.services.analytic;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cryptomarket.cryptoanalyticmicroservice.interfaces.services.CryptoAnalyticInterface;
import com.cryptomarket.cryptoanalyticmicroservice.interfaces.services.VolatilityAnalysisInterface;
import com.cryptomarket.cryptoanalyticmicroservice.kafka.CryptoBriefInfoKafkaDto;
import com.cryptomarket.cryptoanalyticmicroservice.models.CryptoAnalyticInfo;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CryptoAnalyticService implements CryptoAnalyticInterface {
    private OfferAnalysis offerAnalysis;
    private VolatilityAnalysisInterface volatilityAnalysis;

    @Autowired
    public CryptoAnalyticService(OfferAnalysis offerAnalysis, VolatilityAnalysisInterface volatilityAnalysis) {
        this.offerAnalysis = offerAnalysis;
        this.volatilityAnalysis = volatilityAnalysis;
    }

    @Override
    public CryptoAnalyticInfo getAnalyticInfo(CryptoBriefInfoKafkaDto data) {
        return convertCryptoBriefInfoKafkaDtoToCryptoAnalyticInfo.apply(data);

    }

    private Function<CryptoBriefInfoKafkaDto, CryptoAnalyticInfo> convertCryptoBriefInfoKafkaDtoToCryptoAnalyticInfo = data -> {
        CryptoAnalyticInfo cryptoAnalyticInfo = new CryptoAnalyticInfo();
        cryptoAnalyticInfo.setSymbol(data.getSymbol());
        cryptoAnalyticInfo.setName(data.getName());
        cryptoAnalyticInfo.setOfferAnalysisInfo(offerAnalysis.getOfferAnalysisInfo(data.getCirculatingSupply(),
                data.getTotalSupply(), data.getMaxSupply()));
        cryptoAnalyticInfo.setVolatilityInfo(volatilityAnalysis.getVolatility(data.getPercentChange1h(),
                data.getPercentChange24h(), data.getPercentChange7d()));
        return cryptoAnalyticInfo;
    };

}
