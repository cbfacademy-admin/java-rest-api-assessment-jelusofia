package com.cbfacademy.apiassessment.test;


import com.cbfacademy.apiassessment.model.StockTransaction;

import java.util.UUID;

public class StockTransactionTest {
    @Test
    public void testCalculateProfit() {
        // Given
        StockTransaction transaction = new StockTransaction(UUID.randomUUID(), "ABC", 10, 100.0, 120.0, 5.0, 0.0);

        // When
        double profit = transaction.calculateProfit();

        // Then
        assertEquals(950.0, profit, 0.001);
    }

    
}
