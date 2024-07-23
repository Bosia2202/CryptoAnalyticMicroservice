package com.cryptomarket.cryptoanalyticmicroservice.interfaces.database;

import java.util.List;

import com.cryptomarket.cryptoanalyticmicroservice.models.CryptoAnalyticInfo;

public interface SaveCryptocurrencyAnalyticInterface {
    void refreshCryptocurrencyAnalytic(CryptoAnalyticInfo data);

    List<CryptoAnalyticInfo> getCryptocurrencyAnalytic();

    CryptoAnalyticInfo getCryptoAnalyticInfoBySymbol(String symbol);

    CryptoAnalyticInfo getCryptoAnalyticInfoByName(String name);
    
}
