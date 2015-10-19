package com.meirco.chaser.ui;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);

    MainActivityController controller();

    Dependency dependency();
}
