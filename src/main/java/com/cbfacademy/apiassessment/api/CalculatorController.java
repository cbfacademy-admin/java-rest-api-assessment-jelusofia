package com.cbfacademy.apiassessment.api;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.cbfacademy.apiassessment.model.Calculator;
import com.cbfacademy.apiassessment.service.CalculatorService;

@RequestMapping("api/v1/pnlcalculator")
@RestController
public class CalculatorController {
    private final CalculatorService calculationService;

    @Autowired
    public CalculatorController(CalculatorService calculationService){
        this.calculationService =calculationService;
    }

    @PostMapping
    public void addCalculation( @Validated @NonNull @RequestBody Calculator client){
        calculationService.addCalculation(client);
    }
    //@valid and @nonnull not working

    @GetMapping
    public List<Calculator> getAllCalculation() {
        return calculationService.getAllCalculation();
    }

    @GetMapping(path = "{id}")
    public Calculator getCalculationById(@PathVariable("id") UUID id) {
        return calculationService.getCalculationById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCalculationById(@PathVariable("id") UUID id) {
        calculationService.deleteCalculation(id);
    }
    @PutMapping(path = "{id}")
    public void updateCalculation(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Calculator calculationToUpdate ) {
        calculationService.updateCalculation(id, calculationToUpdate);
    }



    
}
