package com.cbfacademy.apiassessment.dao;

import com.cbfacademy.apiassessment.model.Calculator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface CalculatorDao {
    int insertCalculation(UUID id, Calculator calculator);

    default int insertCalculation(Calculator calculator){
        UUID id = UUID.randomUUID();
        return insertCalculation(id, calculator);
    }

    List<Calculator> selectAllCalculation();

    Optional<Calculator> selectCalculationById(UUID id);

    int deleteCalculationById(UUID id);

    int updateCalculationById(UUID id, Calculator calculator);
}
