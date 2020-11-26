package org.example.action;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Navigation implements Action {

    private static final Logger LOGGER = LogManager.getLogger(Navigation.class);

    @Step("Navigate to home page")
    public void openTodoPage() {
        LOGGER.info("Navigate to home page");
        Selenide.open("");
    }

}
