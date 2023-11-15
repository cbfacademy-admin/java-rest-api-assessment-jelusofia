package com.cbfacademy.apiassessment.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.model.Calculator;

@Repository("Dao")
public class CalculatorDataAccessService implements CalculatorDao {
    private static List<Calculator> DB = new ArrayList<>(); //Write it to JSON file using gson library, also need to update and delete?


    @Override
    public int insertCalculation(UUID id, Calculator calculator) {
        DB.add(new Calculator(id, calculator.getName(), calculator.getQuantity(), calculator.getBuyingPrice(), calculator.getSellingPrice(), calculator.getComission(), calculator.getProfit()));
        return 1;
       // throw new UnsupportedOperationException("Unimplemented method 'insertClient'");
    } //submit calculation


    @Override
    public List<Calculator> selectAllCalculation() {
        return DB;
    }

    @Override
    public Double profitCalculation(Calculator profit) {
        return 1.0;
    }



    @Override
    public Optional<Calculator> selectCalculationById(UUID id) {
        // TODO Auto-generated method stub
        return DB.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCalculationById(UUID id) {
        Optional<Calculator> clientMaybe = selectCalculationById(id);
        if (clientMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(clientMaybe.get());
        return 1;
    }

    @Override
    public int updateCalculationById(UUID id, Calculator update) {
       return selectCalculationById(id)
                .map(client -> { //note: learn more about map
                    int indexOfClientToUpdate = DB.indexOf(client);
                    if (indexOfClientToUpdate >= 0){
                        DB.set(indexOfClientToUpdate, new Calculator(id, update.getName(), update.getQuantity(), update.getBuyingPrice(), update.getSellingPrice(), update.getComission(), update.getProfit()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }


}
