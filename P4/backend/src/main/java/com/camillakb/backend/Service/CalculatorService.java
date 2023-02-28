package com.camillakb.backend.Service;
import com.camillakb.backend.Model.CalculatorRequest;
import com.camillakb.backend.Model.CalculatorResponse;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 

    public CalculatorResponse calculate(CalculatorRequest calc) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        String answer = "";
        String err_msg = "";
        
        try {
            answer = (String) engine.eval(calc.calcRequest());
        
        } catch (ScriptException e) {
            err_msg = e.getMessage();
        }

        return new CalculatorResponse(answer, err_msg);
    }
}
