package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.StockTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*This interface defines the methods that the service layer
  must implement for managing stock transactions. 
*/
public interface StockTransactionService {
    // Declares a method to retrieve all stock transactions
    List<StockTransaction> getAllTransactions() ;

    // Declares a method to retrieve a specific stock transaction by its UUID.
    Optional<StockTransaction> getTransactionById(UUID id);

    // Declares a method to add a new stock transaction
    int addTransaction(StockTransaction transaction);
    
    // Declares a method to delete a specific stock transaction by its UUID.
    int deleteTransaction(UUID id);

    //Declares a method to update a specific stock transaction by its UUID with new data.
    int updateTransaction(UUID id, StockTransaction transaction);

}
