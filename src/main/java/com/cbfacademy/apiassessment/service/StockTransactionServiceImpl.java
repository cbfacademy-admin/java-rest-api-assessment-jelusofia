package com.cbfacademy.apiassessment.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.dao.StockTransactionDao;
import com.cbfacademy.apiassessment.model.StockTransaction;

@Service
public class StockTransactionServiceImpl implements StockTransactionService {
    private StockTransactionDao transactionDao;

    @Autowired
    public void StockTransactionService(@Qualifier("Dao") StockTransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void addTransaction(StockTransaction transaction){
        
       // return  calculationDao.insertCalculation(calculation);
        //id double check 21:00 timestamp
    }//profit calculation here

    @Override
    public List<StockTransaction> getAllTransactions() {
        return transactionDao.selectAllTransactions();
    }
    @Override
    public Optional<StockTransaction> getTransactionById(UUID id) {
        return transactionDao.selectTransactionById(id); //algo
    }
    
    @Override
    public void deleteTransaction(UUID id){
       // return  calculationDao.deleteCalculationById(id);       
    }
    @Override
    public void updateTransaction(UUID id, StockTransaction newClient){
        //return  calculationDao.updateCalculationById(id, newClient);       
    }//update calculation data by calculation id
    
}
