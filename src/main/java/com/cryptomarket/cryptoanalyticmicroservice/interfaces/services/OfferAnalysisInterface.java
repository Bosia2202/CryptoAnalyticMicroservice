package com.cryptomarket.cryptoanalyticmicroservice.interfaces.services;

import com.cryptomarket.cryptoanalyticmicroservice.models.OfferAnalysisInfo;

public interface OfferAnalysisInterface {
    OfferAnalysisInfo getOfferAnalysisInfo(double circulatingSupply, double totalSupply, double maxSupply);
}
