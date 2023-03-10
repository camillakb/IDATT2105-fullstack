package com.camillakb.backend.Service;
import com.camillakb.backend.Model.CalculatorRequest;
import com.camillakb.backend.Model.CalculatorResponse;

import ch.qos.logback.classic.Logger;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 

    public CalculatorResponse calculate(CalculatorRequest calc) {
        String answer = "";
        String err_msg = "";
        
        try {
            ExpressionBuilder equation = new ExpressionBuilder(calc.calcRequest());
            answer = String.valueOf(equation.build().evaluate());
        
        } catch (IllegalArgumentException e) {
            logger.warn("Invalid expression.");
            err_msg = "Invalid expression";
        }

        return new CalculatorResponse(answer, err_msg);
    }
}
