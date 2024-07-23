package com.cryptomarket.cryptoanalyticmicroservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cryptomarket.cryptoanalyticmicroservice.models.CryptoAnalyticInfo;

@Repository
public interface RedisRepository extends CrudRepository<CryptoAnalyticInfo, String> {

    List<CryptoAnalyticInfo> findAll();

    CryptoAnalyticInfo findBySymbol(String symbol);

    CryptoAnalyticInfo findByName(String name);

}
