package com.meirco.chaser.ui;

import org.junit.Test;
import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void shouldUseMockDependency() {
        Dependency mock = Mockito.mock(Dependency.class);
        when(mock.which()).thenReturn("mock");
        Dependency dependency = DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new TestModule(mock))
                .build()
                .controller()
                .getDependency();
        assertThat(dependency).isNotNull();
        assertThat(dependency.which()).isEqualTo("mock");
    }


    @Module
    private class TestModule extends MainActivityModule {

        private final Dependency dependency;

        TestModule(Dependency dependency) {
            this.dependency = dependency;
        }

        TestModule() {
            this.dependency = new DependencyImpl();
        }

        @Override
        @Provides
        Dependency dependency() {
            return this.dependency;
        }
    }


    private class DependencyImpl implements Dependency {
        @Override
        public String which() {
            return "impl";
        }
    }

    @Test
    public void shouldGetAChaserNetwork() {
        MainActivityComponent component = DaggerMainActivityComponent.create();
        MainActivityController controller = component.controller();
        assertThat(controller.getNetwork()).isNotNull();
    }

    @Test
    public void shouldAskNetworkForGroupGoal() {
        ChaserNetwork mockNetwork = Mockito.mock(ChaserNetwork.class);
        MainActivityComponent component = DaggerMainActivityComponent
                .builder()
                .mainActivityModule(new NetworkModule(mockNetwork))
                .build();
        component.controller().onCreate();
        verify(mockNetwork).getGroupGoals();
    }

    @Module
    private class NetworkModule extends MainActivityModule {
        private final ChaserNetwork network;

        NetworkModule(ChaserNetwork network) {
            this.network = network;
        }

        @Provides
        ChaserNetwork chaserNetwork(ChaserNetworkImpl impl) {
            return network;
        }
    }

}
