package com.meirco.chaser.ui;

import android.os.Build;
import android.view.View;

import com.meirco.chaser.BuildConfig;
import com.meirco.chaser.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        sdk = Build.VERSION_CODES.KITKAT)
public class MainActivityTest {
    @Test
    public void shouldPass() {
    }

    @Test
    public void onCreate_shouldInflateViews() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        View view = activity.findViewById(R.id.aView);
        assertThat(view).isNotNull();
    }

    @Test
    public void onCreate_shouldConstructAController() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        MainActivityController controller = activity.getController();
        assertThat(controller).isNotNull();
        assertThat(controller.getDependency()).isNotNull();
    }

}
