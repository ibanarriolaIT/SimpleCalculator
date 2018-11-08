package com.altran.ibanarriola.simplecalculator.injection;

import com.altran.ibanarriola.simplecalculator.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class InjectorBuilder {

    @ContributesAndroidInjector(modules = BaseActivityModule.class)
    @PerActivity
    abstract MainActivity contributeMainActivity();
}
