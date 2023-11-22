package com.cbfacademy.apiassessment.api;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.cbfacademy.apiassessment.model.StockTransaction;
import com.cbfacademy.apiassessment.service.StockTransactionService;
import com.cbfacademy.apiassessment.service.StockTransactionServiceImpl;
@SpringBootApplication
@RequestMapping("api/v2/pnlcalculator")
@RestController
public class StockTransactionControllerV2 {
    private StockTransactionService transactionService2;

    @Autowired
    public void StockTransactionController2(StockTransactionService transactionService2){
        this.transactionService2 = transactionService2;
    }

    @GetMapping("/calculateProfit")
    public double calculateProfit(
            @RequestParam String name,
            @RequestParam double sellingPrice,
            @RequestParam int quantity,
            @RequestParam double buyingPrice,
            @RequestParam double commission) {
        StockTransaction transaction = new StockTransaction(UUID.randomUUID(), name, quantity, buyingPrice, sellingPrice, commission, 0.0);
        return transaction.calculateProfit();
    }

   /*  @GetMapping("/orderByPrice") //use algo
    public double calculateProfit(
            @RequestParam String name,
            @RequestParam double sellingPrice,
            @RequestParam int quantity,
            @RequestParam double buyingPrice,
            @RequestParam double commission) {
        StockTransaction transaction = new StockTransaction(UUID.randomUUID(), name, quantity, buyingPrice, sellingPrice, commission, 0.0);
        return transaction.calculateProfit();
    }*/


    @PostMapping("/add")
    public void addTransaction( @Validated @NonNull @RequestBody StockTransaction transaction){
        System.err.println(transaction);
        transactionService2.addTransaction(transaction);
    }
    //@valid and @nonnull not working

    @GetMapping
    public List<StockTransaction> getAllTransactions() {
        return transactionService2.getAllTransactions();
    }

    @GetMapping(path = "{id}")
    public StockTransaction getTransactionById2(@PathVariable("id") UUID id) {
        return transactionService2.getTransactionById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteTransactionById2(@PathVariable("id") UUID id) {
        transactionService2.deleteTransaction(id);
    }
    @PutMapping(path = "{id}")
    public void updateCalculation2(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody StockTransaction transactionToUpdate ) {
        transactionService2.updateTransaction(id, transactionToUpdate);
    }
    
}
