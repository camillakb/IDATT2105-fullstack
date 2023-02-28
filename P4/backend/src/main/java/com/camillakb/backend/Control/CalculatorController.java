package com.camillakb.backend.Control;
import com.camillakb.backend.Model.CalculatorModel;
import com.camillakb.backend.Service.CalculatorService;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Ta i mot svar fra klientene, kalle service for å utføre kalkulasjon/få tak i nødvendig data

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    Logger logger = (Logger) LoggerFactory.getLogger(CalculatorController.class); //Stemmer dette?

    @PostMapping("/")
    public CalculatorModel postCalculation(@RequestBody CalculatorModel calculation){
        return calculatorService.calculate(calculation);
    }

    @RequestMapping("/")
    // ha med alt? er det på riktig plass?
    public String somethingMessage() {
        logger.trace("Sett inn noe fornuftig");
        logger.debug("Sett inn noe fornuftig");
        logger.info("Sett inn noe fornuftig");
        logger.warn("Sett inn noe fornuftig");
        logger.error("Sett inn noe fornuftig");

        return this.calculatorService.calculatorMessage();
    }
}