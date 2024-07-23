package com.cryptomarket.cryptoanalyticmicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cryptomarket.cryptoanalyticmicroservice.interfaces.database.SaveCryptocurrencyAnalyticInterface;
import com.cryptomarket.cryptoanalyticmicroservice.models.CryptoAnalyticInfo;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/analytic")
public class AnalyticController {

    private SaveCryptocurrencyAnalyticInterface hash;

    @Autowired
    public AnalyticController(SaveCryptocurrencyAnalyticInterface hash) {
        this.hash = hash;
    }

    @GetMapping("/all")
    public List<CryptoAnalyticInfo> getAllAnalytic() {
        return hash.getCryptocurrencyAnalytic();
    }

    @GetMapping("/crypto/")
    public CryptoAnalyticInfo getCryptoAnalyticBySymbol(@RequestParam String symbol) {
        return hash.getCryptoAnalyticInfoBySymbol(symbol);
    }

}
