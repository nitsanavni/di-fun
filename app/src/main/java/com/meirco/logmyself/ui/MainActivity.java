package com.meirco.logmyself.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.meirco.logmyself.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainActivityController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDi();
        setContentView(R.layout.activity_main);
    }

    private void initDi() {
        DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule())
                .build()
                .inject(this);
    }

    public MainActivityController getController() {
        return mController;
    }
}