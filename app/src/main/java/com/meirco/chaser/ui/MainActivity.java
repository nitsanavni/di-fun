package com.meirco.chaser.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.meirco.chaser.R;

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
        DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new MainActivityModule())
                .build()
                .inject(this);
    }

    public MainActivityController getController() {
        return mController;
    }
}
