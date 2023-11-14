package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Calculator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.dao.CalculatorDao;
//change to calculatorservice.java
@Service
public class CalculatorService {
    private final CalculatorDao calculationDao;

    @Autowired
    public CalculatorService(@Qualifier("Dao") CalculatorDao calculationDao) {
        this.calculationDao = calculationDao;
    }

    public int addCalculation(Calculator calculation){
        
        return  calculationDao.insertCalculation(calculation);
        //id double check 21:00 timestamp
    }//profit calculation here

    public List<Calculator> getAllCalculation() {
        return calculationDao.selectAllCalculation();
    }

    public Optional<Calculator> getCalculationById(UUID id) {
        return calculationDao.selectCalculationById(id); //algo
    }

    

    public int deleteCalculation(UUID id){
        return  calculationDao.deleteCalculationById(id);       
    }

    public int updateCalculation(UUID id, Calculator newClient){
        return  calculationDao.updateCalculationById(id, newClient);       
    }//update calculation data by calculation id

}
