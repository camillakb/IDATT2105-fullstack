package com.camillakb.backend.Repo;
import com.camillakb.backend.Model.CalculatorModel;

import org.springframework.stereotype.Repository;

//Skal få tak i data/objekter

@Repository
public interface CalculatorRepo {
    CalculatorModel get(String calcString);
    public void addCalcToRepo();
    public void updateCalcInRepo();
    public void removeFromRepo();
}
