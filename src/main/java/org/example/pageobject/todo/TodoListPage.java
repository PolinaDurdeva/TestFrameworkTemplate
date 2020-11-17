package org.example.pageobject.todo;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class TodoListPage implements Page {

    private final SelenideElement newTodoField = $(".new-todo");
    private final ElementsCollection todoList = $$(".todo-list .todo");
    private final SelenideElement toggleAllButton = $("#toggle-all");
    private final ElementsCollection completedTodoList = $$(".todo-list .completed");

    private static final String TOGGLE_CHECKBOX_KEY = ".toggle";
    private static final String DELETE_BUTTON_KEY = ".destroy";

    public SelenideElement getNewTodoField() {
        return newTodoField;
    }

    public ElementsCollection getTodoList() {
        return todoList;
    }

    public SelenideElement getToggleAllButton() {
        return toggleAllButton;
    }

    public ElementsCollection getCompletedTodoList() {
        return completedTodoList;
    }

    public SelenideElement getTodoCheckbox(String todoText) {
        return todoList.find(Condition.text(todoText)).$(TOGGLE_CHECKBOX_KEY);
    }

    public SelenideElement getTodoDeleteButton(String todoText) {
        return todoList.find(Condition.text(todoText)).hover().$(DELETE_BUTTON_KEY);
    }
}
