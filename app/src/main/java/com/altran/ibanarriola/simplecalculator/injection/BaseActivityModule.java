package com.altran.ibanarriola.simplecalculator.injection;

import com.altran.ibanarriola.simplecalculator.logic.CalculatorOperations;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseActivityModule {

    @Provides
    @PerActivity
    CalculatorOperations providesCalculatorOperations() {
        return new CalculatorOperations();
    }
}
