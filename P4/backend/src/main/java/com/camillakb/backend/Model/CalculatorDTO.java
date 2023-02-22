package com.camillakb.backend.Model;

public class CalculatorDTO {
    private String calcString;
    private Object answer;
    private String errorString;
    
    public CalculatorDTO(){}

    public String getCalculatorString() {
        return calcString;
    }

    public void setCalcString(String calcString) {
        this.calcString = calcString;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
