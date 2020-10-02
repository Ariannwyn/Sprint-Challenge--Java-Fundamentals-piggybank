package com.piggybank.piggybank.controllers;

import com.piggybank.piggybank.models.Coin;
import com.piggybank.piggybank.repositories.CoinRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepositories coinRepositories;
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity <?> totalCoins(){
        List<Coin> myList = new ArrayList<>();
        coinRepositories.findAll().iterator().forEachRemaining(myList::add);
        double total = 0;
        for(Coin c : myList){
            if(c.getQuantity() > 1){
                System.out.println(c.getQuantity()+" "+c.getNameplural());
            }
            else{
                System.out.println(c.getQuantity()+" "+c.getName());
            }
            total = total+c.getValue()*c.getQuantity();
        }
        System.out.println("The piggy bank holds "+total);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
