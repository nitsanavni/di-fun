package com.meirco.chaser.ui;

import org.junit.Test;

import dagger.Module;
import dagger.Provides;

import static org.assertj.core.api.Assertions.assertThat;

public class MainActivityControllerTest {
    @Test
    public void shouldPass() {
    }

    @Test
    public void shouldInstanciateController() {
        MainActivityComponent component = DaggerMainActivityComponent.create();
        MainActivityController controller = component.controller();
        assertThat(controller).isNotNull();
        assertThat(controller.getDependency()).isNotNull();
    }

    @Test
    public void shouldInstanciateDependency() {
        MainActivityComponent component = DaggerMainActivityComponent.create();
        Dependency dependency = component.dependency();
        assertThat(dependency).isNotNull();
        assertThat(dependency.which()).isEqualTo("anonymous");
    }

    @Test
    public void shouldInstanciateAnotherDependency() {
        Dependency dependency = DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new TestModule())
                .build()
                .controller()
                .getDependency();
        assertThat(dependency).isNotNull();
        assertThat(dependency.which()).isEqualTo("impl");
    }

    @Module
    private class TestModule extends MainActivityModule {
        @Override
        @Provides
        Dependency dependency() {
            return new DependencyImpl();
        }
    }


    private class DependencyImpl implements Dependency {
        @Override
        public String which() {
            return "impl";
        }
    }
    
}
