package com.meirco.chaser.ui;

import android.os.Build;
import android.view.View;

import com.meirco.chaser.BuildConfig;
import com.meirco.chaser.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import dagger.Module;
import dagger.Provides;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

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

    @Test
    public void shouldUseTestModuleForDI() {
        ActivityController<MainActivity> controller =
                Robolectric.buildActivity(MainActivity.class);
        MainActivity activity = controller.get();
        Dependency mock = Mockito.mock(Dependency.class);
        given(mock.which()).willReturn("our mock");
        activity.setModule(new TestModule(mock));
        controller.setup();
        assertThat(activity.getController().getDependency().which()).isEqualTo("our mock");
    }

    @Module
    private static class TestModule extends MainActivityModule {

        private final Dependency dependency;

        TestModule(Dependency dependency) {
            this.dependency = dependency;
        }

        @Provides
        Dependency dependency() {
            return this.dependency;
        }
    }
}


