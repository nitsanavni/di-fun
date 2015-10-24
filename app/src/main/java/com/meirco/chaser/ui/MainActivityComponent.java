package com.meirco.chaser.ui;

import com.meirco.chaser.goal.GroupGoalViewInjector;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent
        extends GroupGoalViewInjector {
    void inject(MainActivity mainActivity);

    MainActivityController controller();

    Dependency dependency();
}
