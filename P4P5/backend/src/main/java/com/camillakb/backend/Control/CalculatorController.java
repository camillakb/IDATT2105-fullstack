package com.camillakb.backend.Control;
import com.camillakb.backend.Model.CalculatorRequest;
import com.camillakb.backend.Model.CalculatorResponse;
import com.camillakb.backend.Service.CalculatorService;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping(value = "/calculator")

public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @CrossOrigin(origins = "*")
    @PostMapping(value = "")
    public CalculatorResponse postCalculation(@RequestBody CalculatorRequest calculation){
        logger.info("Received request" + calculation);
        return calculatorService.calculate(calculation); 
    }
}