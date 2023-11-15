package com.cbfacademy.apiassessment.dao;

import com.cbfacademy.apiassessment.model.StockTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface StockTransactionDao {
    int insertCalculation(UUID id, StockTransaction calculator);

    default int insertCalculation(StockTransaction calculator){
        UUID id = UUID.randomUUID();
        return insertCalculation(id, calculator);
    }

    List<StockTransaction> selectAllCalculation();

    Double profitCalculation(StockTransaction calculator);

    Optional<StockTransaction> selectCalculationById(UUID id);

    int deleteCalculationById(UUID id);

    int updateCalculationById(UUID id, StockTransaction calculator);
}
