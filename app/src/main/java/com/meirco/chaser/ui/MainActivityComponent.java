package com.meirco.chaser.ui;

import com.meirco.chaser.goal.GroupGoalViewInjector;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent extends GroupGoalViewInjector {
    void inject(MainActivity mainActivity);

    MainActivityController controller();

    Dependency dependency();
}
