package com.meirco.logmyself.ui;

import dagger.Component;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    MainActivityController mainActivityController();
}
