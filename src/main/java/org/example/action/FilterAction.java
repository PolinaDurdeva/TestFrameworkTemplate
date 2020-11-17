package org.example.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pageobject.todo.FooterComponent;

public class FilterAction implements Action {

    private static final Logger LOGGER = LogManager.getLogger(FilterAction.class);

    private final FooterComponent footer;

    public FilterAction() {
        this.footer = new FooterComponent();
    }

    public void selectAll() {
        LOGGER.info("Filter by All");
        footer.getFilterAllLink().click();
    }

    public void selectCompleted() {
        LOGGER.info("Filter by Completed");
        footer.getFilterCompletedLink().click();
    }

    public void selectActive() {
        LOGGER.info("Filter by Active");
        footer.getFilterActiveLink().click();
    }
}
