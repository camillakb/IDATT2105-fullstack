package com.camillakb.backend.Service;
import com.camillakb.backend.DAO.CalcRepo;
import com.camillakb.backend.Entity.Calculation;
import com.camillakb.backend.Model.CalculatorRequest;
import com.camillakb.backend.Model.CalculatorResponse;

import ch.qos.logback.classic.Logger;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    @Autowired
    private CalcRepo calcRepo;
    @Autowired

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 

    /**
     * Method to perform calculation and save it to the users database.
     * @param calc equation to calculate
     * @param user the user that performs the calculation
     * @return the equation including an answer, and an error message (empty if there's no error)
     */
    public CalculatorResponse calculate(CalculatorRequest calc) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String answer = "";
        String err_msg = "";
        
        try {
            //perform calculation
            ExpressionBuilder equation = new ExpressionBuilder(calc.calcRequest());
            answer = calc.calcRequest() + " = " + String.valueOf(equation.build().evaluate());

            //save result to user's database
            Calculation calculation = new Calculation();
            calculation.setCalculation(answer);
            calculation.setUser(username);
            calcRepo.save(calculation);

        } catch (IllegalArgumentException e) {
            logger.warn("Invalid expression.");
            err_msg = "Invalid expression";
        }

        return new CalculatorResponse(answer, err_msg);
    }

    /**
     * Method to get the last calculations for a user
     * @param username 
     * @param pageNum 
     * @return
     */
    public List<String> getCalculations(String username, int pageNum) {
        Page<Calculation> calculations = calcRepo.findAllByUsername(username, PageRequest.of(pageNum, 10));
        List<String> listofCalc = calculations
            .getContent()
            .stream()
            .map(Calculation::getCalculation)
            .toList();

        return listofCalc;
    }
}
