package com.meirco.logmyself.ui;

import android.os.Build;
import android.view.View;

import com.meirco.logmyself.BuildConfig;
import com.meirco.logmyself.R;

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
}
