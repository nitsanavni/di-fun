package com.meirco.logmyself.ui;

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
        };
    }
}
