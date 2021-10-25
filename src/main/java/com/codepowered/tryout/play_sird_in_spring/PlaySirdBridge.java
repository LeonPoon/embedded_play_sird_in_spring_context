package com.codepowered.tryout.play_sird_in_spring;

import com.google.inject.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.guice.module.SpringModule;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class PlaySirdBridge implements ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(PlaySirdBridge.class);
    private ApplicationContext applicationContext;

    public PlaySirdBridge() {
        LOG.info("constructed {}", this);
    }

    @Inject
    public void setDummyBean(DummyBean dummyBean) {
        LOG.info("setDummyBean {}", dummyBean);
    }

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void startApp() {
        LOG.info("{} startApp", this);
        Module module = new SpringModule(applicationContext);
        MainBean main = new MainBean(module);
        main.server();
    }
}
