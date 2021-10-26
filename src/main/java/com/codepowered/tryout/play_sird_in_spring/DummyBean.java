package com.codepowered.tryout.play_sird_in_spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyBean implements DummyInterface {

    private static final Logger LOG = LoggerFactory.getLogger(DummyBean.class);

    public DummyBean() {
        LOG.info("constructed {}", this);
    }
}
