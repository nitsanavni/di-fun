package com.meirco.logmyself.ui;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    @Provides
    MainActivityController mainActivityController(MainActivityControllerImpl impl) {
        return impl;
    }
}
