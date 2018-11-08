package com.altran.ibanarriola.simplecalculator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.altran.ibanarriola.simplecalculator.R;
import com.altran.ibanarriola.simplecalculator.logic.CalculatorOperations;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerAppCompatActivity;

import static com.altran.ibanarriola.simplecalculator.logic.CalculatorOperations.ADDITION;
import static com.altran.ibanarriola.simplecalculator.logic.CalculatorOperations.SUBTRACTION;

public class MainActivity extends DaggerAppCompatActivity implements HasActivityInjector {

    @Inject
    CalculatorOperations calculatorOperations;

    @BindView(R.id.resultText)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonZero, R.id.buttonOne, R.id.buttonTwo,
            R.id.buttonThree, R.id.buttonFour, R.id.buttonFive, R.id.buttonSix, R.id.buttonSeven,
            R.id.buttonEight, R.id.buttonNine, R.id.buttonDot, R.id.buttonClear, R.id.buttonEqual})
    public void onClick(View v) {
        String newTextValue = tvResult.getText().toString();
        switch (v.getId()) {
            case R.id.buttonDot:
                newTextValue = calculatorOperations.addNumber(".", newTextValue);
                break;
            case R.id.buttonZero:
                newTextValue = calculatorOperations.addNumber("0", newTextValue);
                break;
            case R.id.buttonOne:
                newTextValue = calculatorOperations.addNumber("1", newTextValue);
                break;
            case R.id.buttonTwo:
                newTextValue = calculatorOperations.addNumber("2", newTextValue);
                break;
            case R.id.buttonThree:
                newTextValue = calculatorOperations.addNumber("3", newTextValue);
                break;
            case R.id.buttonFour:
                newTextValue = calculatorOperations.addNumber("4", newTextValue);
                break;
            case R.id.buttonFive:
                newTextValue = calculatorOperations.addNumber("5", newTextValue);
                break;
            case R.id.buttonSix:
                newTextValue = calculatorOperations.addNumber("6", newTextValue);
                break;
            case R.id.buttonSeven:
                newTextValue = calculatorOperations.addNumber("7", newTextValue);
                break;
            case R.id.buttonEight:
                newTextValue = calculatorOperations.addNumber("8", newTextValue);
                break;
            case R.id.buttonNine:
                newTextValue = calculatorOperations.addNumber("9", newTextValue);
                break;
            case R.id.buttonAdd:
                if (!(calculatorOperations.getValues().isEmpty() &&
                        calculatorOperations.getCurrentNumber().isEmpty()))
                    newTextValue = calculatorOperations.addOperator(ADDITION, newTextValue);
                break;
            case R.id.buttonSubtract:
                if (!calculatorOperations.getCurrentNumber().equals("-")) {
                    if (!(calculatorOperations.getValues().isEmpty() &&
                            calculatorOperations.getCurrentNumber().isEmpty())) {
                        newTextValue = calculatorOperations.addOperator(SUBTRACTION, newTextValue);
                    } else {
                        newTextValue = calculatorOperations.addNumber("-", newTextValue);
                    }
                }
                break;
            case R.id.buttonClear:
                calculatorOperations.clearAll();
                newTextValue = "";
                break;
            case R.id.buttonEqual:
                newTextValue = calculatorOperations.calculateValue(newTextValue);
                break;
        }
        tvResult.setText(newTextValue);
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }
}
