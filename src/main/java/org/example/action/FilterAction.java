package org.example.action;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pageobject.todo.FooterComponent;

public class FilterAction implements Action {

    private static final Logger LOGGER = LogManager.getLogger(FilterAction.class);

    private final FooterComponent footer;

    public FilterAction() {
        this.footer = new FooterComponent();
    }

    @Step("Show all todo items")
    public void selectAll() {
        LOGGER.info("Filter by All");
        footer.getFilterAllLink().click();
    }

    @Step("Show only completed todo items")
    public void selectCompleted() {
        LOGGER.info("Filter by Completed");
        footer.getFilterCompletedLink().click();
    }

    @Step("Show only active todo items")
    public void selectActive() {
        LOGGER.info("Filter by Active");
        footer.getFilterActiveLink().click();
    }
}
