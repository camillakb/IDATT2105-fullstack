package com.camillakb.backend.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.stereotype.Service;

import com.camillakb.backend.Model.CalculatorModel;

//mellomlaget til kontrolleren og "resten"

@Service
public class CalculatorService {
    
    public CalculatorModel calculate(CalculatorModel calc) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        
        try {
            Object answer = engine.eval(calc.getCalculatorString());
            calc.setAnswer(answer);
            return calc;
        
        } catch (ScriptException e) {
            calc.setErrorString("ERROR: Please press AC.");
            return calc;
        }
    }

    public String calculatorMessage() {
        return "hei"; //Fiks dette!
    }
}
