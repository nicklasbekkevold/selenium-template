package org.example.project.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.UUID;

public final class StepLogger {

    public static Logger logger = LoggerFactory.getLogger(StepLogger.class);

    @Step("[INFO] {info}")
    public static void info(String info) {
        logger.info(info);
    }

    public static void error(String error) {
        String uuid = UUID.randomUUID().toString();
        try {
            AllureLifecycle allureLifeCycle = Allure.getLifecycle();
            allureLifeCycle.startStep(uuid, new StepResult().setStatus(Status.FAILED).setName(error));
            logger.error(error);
            allureLifeCycle.stopStep(uuid);
        } catch (NoSuchElementException e) {
            info(error);
        }
    }
}
