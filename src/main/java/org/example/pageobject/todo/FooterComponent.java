package org.example.pageobject.todo;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class FooterComponent implements Page{

    private final SelenideElement clearCompletedButton = $(".clear-completed");
    private final SelenideElement filterCompletedLink = $("a[href='#/completed']");
    private final SelenideElement filterAllLink = $("a[href='#/all']");
    private final SelenideElement filterActiveLink = $("a[href='#/active']");
    private final SelenideElement countTodoItems = $(".todo-count");

    public SelenideElement getClearCompletedButton() {
        return clearCompletedButton;
    }

    public SelenideElement getFilterCompletedLink() {
        return filterCompletedLink;
    }

    public SelenideElement getFilterAllLink() {
        return filterAllLink;
    }

    public SelenideElement getFilterActiveLink() {
        return filterActiveLink;
    }

    public SelenideElement getCountTodoItems() {
        return countTodoItems;
    }
}
