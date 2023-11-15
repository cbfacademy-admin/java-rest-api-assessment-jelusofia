package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.StockTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockTransactionService {

    List<StockTransaction> getAllTransactions() ;

    Optional<StockTransaction> getTransactionById(UUID id);

    void addTransaction(StockTransaction transaction);
    
    void deleteTransaction(UUID id);

    void updateTransaction(UUID id, StockTransaction transaction);

}
