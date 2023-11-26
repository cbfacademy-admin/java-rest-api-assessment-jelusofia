package com.cbfacademy.apiassessment.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.dao.StockTransactionDao;
import com.cbfacademy.apiassessment.model.StockTransaction;

//This class is a service layer
@Service
public class StockTransactionServiceImpl implements StockTransactionService {
    private StockTransactionDao transactionDao;

    //Constructor 
    @Autowired
    public void StockTransactionService(@Qualifier("Dao") StockTransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    //Adds a new stock transaction using the insertStockTransaction method
    @Override
    public int addTransaction(StockTransaction transaction){    
       return transactionDao.insertStockTransaction(transaction);
    }

    //Retrieves all stock transactions using the selectAllTransactions method
    @Override
    public List<StockTransaction> getAllTransactions() {
        return transactionDao.selectAllTransactions();
    }

    //Retrieves a specific stock transaction by its UUID using the selectTransactionById method
    @Override
    public Optional<StockTransaction> getTransactionById(UUID id) {
        return transactionDao.selectTransactionById(id); //algo
    }

    //Deletes a specific stock transaction by its UUID using the deleteTransactionById method 
    @Override
    public int deleteTransaction(UUID id){
       return  transactionDao.deleteTransactionById(id);       
    }

    //Updates a specific stock transaction by its UUID with new data using the updateTransactionById method
    @Override
    public int updateTransaction(UUID id, StockTransaction newClient){
        return  transactionDao.updateTransactionById(id, newClient);       
    }
}
