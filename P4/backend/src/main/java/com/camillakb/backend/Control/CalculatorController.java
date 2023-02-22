package com.camillakb.backend.Control;
import com.camillakb.backend.Model.CalculatorDTO;
import com.camillakb.backend.Service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/")
    public CalculatorDTO postCalculation(@RequestBody CalculatorDTO calculation){
        return calculatorService.calculate(calculation);
    }
}