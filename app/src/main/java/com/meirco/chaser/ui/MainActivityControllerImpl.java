package com.meirco.chaser.ui;

import javax.inject.Inject;

public class MainActivityControllerImpl
        implements MainActivityController {
    @Inject
    Dependency dependency;
    @Inject
    ChaserNetwork network;

    @Inject
    MainActivityControllerImpl() {
    }


    @Override
    public Dependency getDependency() {
        return dependency;
    }

    @Override
    public ChaserNetwork getNetwork() {
        return network;
    }

    @Override
    public void onCreate() {
        network.getGroupGoals();
    }
}
