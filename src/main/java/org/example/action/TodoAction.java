package org.example.action;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pageobject.todo.TodoListPage;

public class TodoAction implements Action {

    private static final Logger LOGGER = LogManager.getLogger(TodoAction.class);

    private final TodoListPage todoListPage;

    public TodoAction() {
        this.todoListPage = new TodoListPage();
    }

    public ElementsCollection getTodoList() {
        return todoListPage.getTodoList();
    }

    public ElementsCollection getCompleted() {
        return todoListPage.getCompletedTodoList();
    }

    @Step("Add todo item with text {todoText}")
    public TodoAction addNewTodo(String todoText) {
        LOGGER.info("Adding new todo with text - {}", todoText);
        todoListPage.getNewTodoField().setValue(todoText).pressEnter();
        return this;
    }

    @Step("Mark todo item with text {todoText} as completed")
    public TodoAction markAsCompleted(String todoText) {
        LOGGER.info("Marking as completed todo with text - {}", todoText);
        todoListPage.getTodoCheckbox(todoText).click();
        return this;
    }

    @Step("Remove todo item with text {todoText}")
    public TodoAction deleteTodo(String todoText) {
        LOGGER.info("Removing todo with text - {}", todoText);
        todoListPage.getTodoDeleteButton(todoText).click();
        return this;
    }

    @Step("Mark all todo items as completed")
    public TodoAction toggleAllTodo() {
        todoListPage.getToggleAllButton().shouldBe(Condition.visible);
        todoListPage.getToggleAllButton().click();
        return this;
    }

}
