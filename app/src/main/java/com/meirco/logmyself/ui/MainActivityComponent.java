package com.meirco.logmyself.ui;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
    MainActivityController mainActivityController();
}
