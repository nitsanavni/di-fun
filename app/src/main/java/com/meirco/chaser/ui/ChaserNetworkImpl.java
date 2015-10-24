package com.meirco.chaser.ui;

import com.meirco.chaser.goal.GroupGoal;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ChaserNetworkImpl implements ChaserNetwork {
    @Inject
    ChaserNetworkImpl() {
    }

    @Override
    public GroupGoal getGroupGoals() {
        return null;
    }
}
