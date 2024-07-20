package com.cryptomarket.cryptoanalyticmicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cryptomarket.cryptoanalyticmicroservice.services.status.offer.DeficitAnalysisStatus;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OfferAnalysisService {

    private DeficitAnalysisStatus deficitAnalysisStatus;

    private float getPercentIssued(float circulatingSupply, float totalSupply) {
        return (circulatingSupply / totalSupply) * 100;
    }

    private float getRemainingSupply(float totalSupply, float circulatingSupply) {
        return totalSupply - circulatingSupply;
    }

    private float getPercentOfMaxOffer(float circulatingSupply, float maxSupply) {
        return (circulatingSupply / maxSupply) * 100;
    }

    private float getSupplyGrowthPotential(float circulatingSupply, float maxSupply) {
        return (maxSupply - circulatingSupply) / circulatingSupply * 100;
    }

    private DeficitAnalysisStatus getDeficitAnalysis(float maxSupply, float totalSupply) {
        if (maxSupply==totalSupply) {
            return deficitAnalysisStatus.FIXED;
        } else {
            if (maxSupply>totalSupply) {
                return deficitAnalysisStatus.INFLATIONARY;
            } else {
                return deficitAnalysisStatus.DEFLATIONARY;
            }
        }
    }

}
