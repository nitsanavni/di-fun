package com.meirco.chaser;

import android.app.Application;

public class ChaserApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initParse();
    }

    private void initParse() {
        new ChaserParseInitializer(this).init();
    }

}
