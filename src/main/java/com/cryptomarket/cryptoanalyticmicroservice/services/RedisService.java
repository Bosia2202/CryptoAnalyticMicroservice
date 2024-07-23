package com.cryptomarket.cryptoanalyticmicroservice.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cryptomarket.cryptoanalyticmicroservice.interfaces.database.SaveCryptocurrencyAnalyticInterface;
import com.cryptomarket.cryptoanalyticmicroservice.models.CryptoAnalyticInfo;
import com.cryptomarket.cryptoanalyticmicroservice.repositories.RedisRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RedisService implements SaveCryptocurrencyAnalyticInterface {
    private RedisRepository redisRepository;

    @Autowired
    public RedisService(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }


    //TODO:Подумать как реализовать обновление и будет ли save перезаписывать метод
    @Override
    public void refreshCryptocurrencyAnalytic(CryptoAnalyticInfo data) {
        redisRepository.deleteById(data.getSymbol());
        redisRepository.save(data);
        log.info("Data refresh");
    }

    @Override
    public List<CryptoAnalyticInfo> getCryptocurrencyAnalytic() {
        List<CryptoAnalyticInfo> data = redisRepository.findAll();
        if (data.isEmpty()) {
            throw new NoSuchElementException("CryptoAnalytic doesn't found");
        }
        return data;
    }

    @Override
    public CryptoAnalyticInfo getCryptoAnalyticInfoBySymbol(String symbol) {
        return Optional.ofNullable(redisRepository.findBySymbol(symbol))
                .orElseThrow(() -> new NoSuchElementException("Currency " + symbol + " doesn't found"));
    }

    @Override
    public CryptoAnalyticInfo getCryptoAnalyticInfoByName(String name) {
        return Optional.ofNullable(redisRepository.findByName(name))
                .orElseThrow(() -> new NoSuchElementException("Currency " + name + " doesn't found"));
    }
}
