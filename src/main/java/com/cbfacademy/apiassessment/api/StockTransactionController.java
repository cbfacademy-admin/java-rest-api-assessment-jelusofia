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

@RequestMapping("api/v1/pnlcalculator")
@RestController
public class StockTransactionController {
    private final StockTransactionService transactionService;

    @Autowired
    public StockTransactionController(StockTransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public void addTransaction( @Validated @NonNull @RequestBody StockTransaction transaction){
        transactionService.addTransaction(transaction);
    }
    //@valid and @nonnull not working

    @GetMapping
    public List<StockTransaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping(path = "{id}")
    public StockTransaction getTransactionById(@PathVariable("id") UUID id) {
        return transactionService.getTransactionById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteTransactionById(@PathVariable("id") UUID id) {
        transactionService.deleteTransaction(id);
    }
    @PutMapping(path = "{id}")
    public void updateCalculation(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody StockTransaction transactionToUpdate ) {
        transactionService.updateTransaction(id, transactionToUpdate);
    }



    
}
