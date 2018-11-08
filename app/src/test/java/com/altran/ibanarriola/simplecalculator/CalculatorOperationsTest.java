package com.altran.ibanarriola.simplecalculator;

import com.altran.ibanarriola.simplecalculator.logic.CalculatorOperations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorOperationsTest {

    CalculatorOperations calculatorOperations;

    @Before
    public void setUp(){
        calculatorOperations = new CalculatorOperations();
    }

    @Test
    public void testAddNumber(){
        String result = "";
        result = calculatorOperations.addNumber("0", result);
        assertEquals("0", result);
        result = calculatorOperations.addNumber("0", result);
        assertEquals("0", result);
        result = calculatorOperations.addNumber("3", result);
        assertEquals("3", result);
        result = calculatorOperations.addNumber("5", result);
        assertEquals("35", result);
        result = calculatorOperations.addNumber(".", result);
        assertEquals("35.", result);
        result = calculatorOperations.addNumber(".", result);
        assertEquals("35.", result);
        result = calculatorOperations.addNumber("7", result);
        assertEquals("35.7", result);
    }

    @Test
    public void testAddOperation(){
        String result = "";
        result = calculatorOperations.addOperator(CalculatorOperations.ADDITION, result);
        assertEquals("", result);
        result = calculatorOperations.addNumber("3", result);
        result = calculatorOperations.addOperator(CalculatorOperations.ADDITION, result);
        assertEquals("3+", result);
        result = calculatorOperations.addOperator(CalculatorOperations.SUBTRACTION, result);
        assertEquals("3+", result);
        result = calculatorOperations.addNumber("5", result);
        assertEquals("3+5", result);
        result = calculatorOperations.addOperator(CalculatorOperations.SUBTRACTION, result);
        assertEquals("3+5-", result);
    }

    @Test
    public void testCalculateValue(){
        String result = "";
        result = calculatorOperations.addNumber("3", result);
        result = calculatorOperations.addNumber("5", result);
        result = calculatorOperations.addNumber(".", result);
        result = calculatorOperations.addNumber("7", result);
        result = calculatorOperations.calculateValue(result);
        assertEquals("35.7", result);
        result = calculatorOperations.addOperator(CalculatorOperations.ADDITION, result);
        result = calculatorOperations.addNumber("5", result);
        result = calculatorOperations.addOperator(CalculatorOperations.SUBTRACTION, result);
        result = calculatorOperations.addNumber("7", result);
        result = calculatorOperations.calculateValue(result);
        assertEquals("33.7", result);
        result = calculatorOperations.addNumber("8", result);
        result = calculatorOperations.addOperator(CalculatorOperations.SUBTRACTION, result);
        result = calculatorOperations.addNumber("3", result);
        result = calculatorOperations.calculateValue(result);
        assertEquals("30.78", result);
    }
}
