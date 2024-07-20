package com.cryptomarket.cryptoanalyticmicroservice.services.status.offer;

import org.springframework.stereotype.Component;

@Component
public enum DeficitAnalysisStatus {
    FIXED,
    INFLATIONARY,
    DEFLATIONARY
}
