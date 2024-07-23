package com.cryptomarket.cryptoanalyticmicroservice.models;

import java.io.Serializable;

import com.cryptomarket.cryptoanalyticmicroservice.services.status.offer.DeficitAnalysisStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OfferAnalysisInfo implements Serializable{
 private final float percentIssued;
 private final double remainingSupply;
 private final double percentOfMaxOffer;
 private final double supplyGrowthPotential;
 private final DeficitAnalysisStatus deficitStatus; 
}
