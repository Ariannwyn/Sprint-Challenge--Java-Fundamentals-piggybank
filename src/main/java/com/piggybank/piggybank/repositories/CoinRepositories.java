package com.piggybank.piggybank.repositories;

import com.piggybank.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepositories extends CrudRepository <Coin, Long>{

}
