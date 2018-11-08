package com.altran.ibanarriola.simplecalculator.logic;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CalculatorOperations {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';

    private String currentNumber = "";
    private List<Double> values = new ArrayList<>();
    private List<Character> operators = new ArrayList<>();

    @Inject
    public CalculatorOperations() {
    }

    public String getCurrentNumber() {
        return currentNumber;
    }

    public List<Double> getValues() {
        return values;
    }

    public String addNumber(String number, String currentText) {
        if (number.equals("0")) {
            if (currentNumber.equals("0") ||
                    currentNumber.equals("-0")) {
                return currentText;
            }
        }
        if (number.equals(".")) {
            if (currentNumber.contains(".")) {
                return currentText;
            }
            if (currentNumber.isEmpty()) {
                number = "0.";
            }
        }
        if (currentNumber.equals("0") || currentNumber.equals("-0")) {
            if (!number.equals("."))
                currentText = removeZero(currentText);
        }
        currentNumber = currentNumber + number;
        return currentText + number;
    }

    public String addOperator(char operator, String currentText) {
        if (currentNumber.isEmpty()) {
            return currentText;
        }
        values.add(Double.parseDouble(currentNumber));
        currentNumber = "";
        operators.add(operator);
        return currentText + String.valueOf(operator);
    }

    public String calculateValue(String currentText) {
        if (!currentNumber.isEmpty()) {
            values.add(Double.parseDouble(currentNumber));
        }
        if (values.size() > 0) {
            double result = values.get(0);
            for (int i = 0; i + 1 < values.size(); i++) {
                if (operators.get(i) == ADDITION) {
                    result = result + values.get(i + 1);
                } else if (operators.get(i) == SUBTRACTION) {
                    result = result - values.get(i + 1);
                }
            }
            currentNumber = String.valueOf(result);
            values = new ArrayList<>();
            operators = new ArrayList<>();
            if ((int) result == result) {
                return String.valueOf((int) result);
            } else {
                return String.valueOf(result);
            }
        }
        return currentText;
    }

    public void clearAll() {
        values = new ArrayList<>();
        operators = new ArrayList<>();
        currentNumber = "";
    }

    private String removeZero(String currentText) {
        currentText = currentText.substring(0, currentText.length() - 1);
        return currentText;
    }
}
