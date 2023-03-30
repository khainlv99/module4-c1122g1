package com.codegym.service.impl;

import com.codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public double caculator(String calculate,double numberOne, double numberTwo) {
        double result = 0.0;
        switch (calculate){
            case "Addition(+)":
                result = numberOne + numberTwo;
                break;
            case "Subtraction(-)":
                result = numberOne - numberTwo;
                break;
            case "Multiplication(X)":
                result = numberOne * numberTwo;
                break;
            case "Division(/)":
                result = numberOne / numberTwo;
                break;
        }
        return result;
    }
}
