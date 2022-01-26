package com.endava.listener;

import org.apache.logging.log4j.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.launcher.TestExecutionListener;
import org.springframework.test.context.TestContext;

public class CustomTestExecutionListener implements TestExecutionListener {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomTestExecutionListener.class);

    public void beforeTestClass(TestContext testContext) throws Exception {
        LOGGER.info("beforeTestClass : {}", testContext.getTestClass());
    };

    public void prepareTestInstance(TestContext testContext) throws Exception {
        LOGGER.info("prepareTestInstance : {}", testContext.getTestClass());
    };

    public void beforeTestMethod(TestContext testContext) throws Exception {
        LOGGER.info("beforeTestMethod : {}", testContext.getTestMethod());
    };

    public void afterTestMethod(TestContext testContext) throws Exception {
        LOGGER.info("afterTestMethod : {}", testContext.getTestMethod());
    };

    public void afterTestClass(TestContext testContext) throws Exception {
        LOGGER.info("afterTestClass : {}", testContext.getTestClass());
    }
}