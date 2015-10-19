package com.meirco.logmyself.ui;

import org.junit.Test;

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

}
