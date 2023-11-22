package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.StockTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockTransactionService {

    List<StockTransaction> getAllTransactions() ;

    Optional<StockTransaction> getTransactionById(UUID id);

    int addTransaction(StockTransaction transaction);
    
    int deleteTransaction(UUID id);

    int updateTransaction(UUID id, StockTransaction transaction);

}
