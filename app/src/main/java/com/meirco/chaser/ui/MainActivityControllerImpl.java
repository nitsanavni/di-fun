package com.meirco.chaser.ui;

import javax.inject.Inject;

public class MainActivityControllerImpl implements MainActivityController {

    @Inject
    Dependency dependency;

    @Inject
    MainActivityControllerImpl() {
    }


    @Override
    public Dependency getDependency() {
        return dependency;
    }
}