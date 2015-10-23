package com.meirco.chaser.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.meirco.chaser.R;

import javax.inject.Inject;

public class MainActivity
        extends AppCompatActivity
        implements HasComponent {
    @Inject
    MainActivityController mController;
    private MainActivityModule mModule;
    private MainActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDi();
        mController.onCreate();
        setContentView(R.layout.activity_main);
    }

    private void initDi() {
        if (null == mModule) {
            mModule = new MainActivityModule();
        }
        mComponent = DaggerMainActivityComponent
                .builder()
                .mainActivityModule(mModule)
                .build();
        mComponent.inject(this);
    }

    public MainActivityController getController() {
        return mController;
    }

    public void setModule(MainActivityModule module) {
        this.mModule = module;
    }

    @Override
    public Object getComponent() {
        return mComponent;
    }
}
