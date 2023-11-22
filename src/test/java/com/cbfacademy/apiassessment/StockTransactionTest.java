package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.cbfacademy.apiassessment.model.StockTransaction;

@DisplayName(value = "The StockTransaction class should")
public class StockTransactionTest {
    @Test
    @DisplayName(value = "calculate the profit")
    public void testCalculateProfit() {
        StockTransaction transaction = new StockTransaction(UUID.randomUUID(), "ABC", 10, 100.0, 120.0, 5.0, 0.0);

        double profit = transaction.calculateProfit();

        assertEquals(950.0, profit, 0.001);
    }

    @Test
    @DisplayName(value = "have working getters - Part I") 
    public void testGetters1() { //excpet getProfit
        UUID id = UUID.randomUUID();
        String name = "XYZ";
        int quantity = 5;
        double buyingPrice = 50.0;
        double sellingPrice = 60.0;
        double commission = 2.0;

        StockTransaction transaction = new StockTransaction(id, name, quantity, buyingPrice, sellingPrice, commission, 0.0);

        UUID actualId = transaction.getId();
        String actualName = transaction.getName();
        int actualQuantity = transaction.getQuantity();
        double actualBuyingPrice = transaction.getBuyingPrice();
        double actualSellingPrice = transaction.getSellingPrice();
        double actualCommission = transaction.getCommission();

        assertEquals(id, actualId);
        assertEquals(name, actualName);
        assertEquals(quantity, actualQuantity);
        assertEquals(buyingPrice, actualBuyingPrice, 0.001);
        assertEquals(sellingPrice, actualSellingPrice, 0.001);
        assertEquals(commission, actualCommission, 0.001);
    }
    @Test
    @DisplayName(value = "have working getters - Part II") 
    public void testGetters2() { //excpet getProfit
        UUID id = UUID.randomUUID();
        String name = "TestName";
        int quantity = 5;
        double buyingPrice = 50.0;
        double sellingPrice = 60.0;
        double commission = 2.0;

        StockTransaction transaction = new StockTransaction(id, name, quantity, buyingPrice, sellingPrice, commission, 0.0);

        UUID actualId = transaction.getId();
        String actualName = transaction.getName();
        int actualQuantity = transaction.getQuantity();
        double actualBuyingPrice = transaction.getBuyingPrice();
        double actualSellingPrice = transaction.getSellingPrice();
        double actualCommission = transaction.getCommission();

        assertEquals(id, actualId);
        assertEquals(name, actualName);
        assertEquals(quantity, actualQuantity);
        assertEquals(buyingPrice, actualBuyingPrice, 0.001);
        assertEquals(sellingPrice, actualSellingPrice, 0.001);
        assertEquals(commission, actualCommission, 0.001);
    }


    @Test
    @DisplayName(value = "have a working Profit getter") 
    public void testGetProfit() {
        double profit = 123.45;
        StockTransaction transaction = new StockTransaction(UUID.randomUUID(), "TestProfit", 10, 100.0, 120.0, 5.0, profit);

        double actualProfit = transaction.getProfit();

        assertEquals(profit, actualProfit, 0.001);
    }
    
}
