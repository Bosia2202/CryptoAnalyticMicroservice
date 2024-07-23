package com.cryptomarket.cryptoanalyticmicroservice.services.analytic;

import org.springframework.stereotype.Component;

import com.cryptomarket.cryptoanalyticmicroservice.interfaces.services.OfferAnalysisInterface;
import com.cryptomarket.cryptoanalyticmicroservice.models.OfferAnalysisInfo;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.offer.DeficitAnalysisStatus;

@Component
public class OfferAnalysis implements OfferAnalysisInterface {

    @Override
    public OfferAnalysisInfo getOfferAnalysisInfo(double circulatingSupply, double totalSupply, double maxSupply) {
        return new OfferAnalysisInfo(
                getPercentIssued(circulatingSupply, totalSupply),
                getRemainingSupply(totalSupply, circulatingSupply),
                getPercentOfMaxOffer(circulatingSupply, maxSupply),
                getSupplyGrowthPotential(circulatingSupply, maxSupply),
                getDeficitAnalysis(maxSupply, totalSupply));
    }

    private float getPercentIssued(double circulatingSupply, double totalSupply) {
        return (float) (circulatingSupply / totalSupply) * 100;
    }

    private double getRemainingSupply(double totalSupply, double circulatingSupply) {
        return totalSupply - circulatingSupply;
    }

    private double getPercentOfMaxOffer(double circulatingSupply, double maxSupply) {
        return (circulatingSupply / maxSupply) * 100;
    }

    private double getSupplyGrowthPotential(double circulatingSupply, double maxSupply) {
        return (maxSupply - circulatingSupply) / circulatingSupply * 100;
    }

    private DeficitAnalysisStatus getDeficitAnalysis(double maxSupply, double totalSupply) {
        if (maxSupply == totalSupply) {
            return DeficitAnalysisStatus.FIXED;
        } else {
            if (maxSupply > totalSupply) {
                return DeficitAnalysisStatus.INFLATIONARY;
            } else {
                return DeficitAnalysisStatus.DEFLATIONARY;
            }
        }
    }

}
