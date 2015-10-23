package com.meirco.chaser.ui;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent extends GroupGoalViewInjector {
    void inject(MainActivity mainActivity);

    MainActivityController controller();

    Dependency dependency();
}
