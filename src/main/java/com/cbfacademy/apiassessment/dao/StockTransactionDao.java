package com.cbfacademy.apiassessment.dao;
import com.cbfacademy.apiassessment.model.StockTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface StockTransactionDao {
    int insertStockTransaction(UUID id, StockTransaction transaction);

    default int insertStockTransaction(StockTransaction transaction){
        //UUID id = UUID.randomUUID();
        return insertStockTransaction(UUID.randomUUID(), transaction);
    }

    List<StockTransaction> selectAllTransactions();

    Double profitCalculation(StockTransaction transaction);

    Optional<StockTransaction> selectTransactionById(UUID id);

    int deleteTransactionById(UUID id);

    int updateTransactionById(UUID id, StockTransaction transaction);
}
