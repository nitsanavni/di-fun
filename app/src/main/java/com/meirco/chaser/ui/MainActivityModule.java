package com.meirco.chaser.ui;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    MainActivityController mainActivityController(
            MainActivityControllerImpl impl) {
        return impl;
    }

    @Provides
    Dependency dependency() {
        return new Dependency() {
            @Override
            public String which() {
                return "anonymous";
            }
        };
    }
}
