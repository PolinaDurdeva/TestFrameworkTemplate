package org.example.action;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pageobject.todo.TodoListPage;

public class TodoAction implements Action{

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

    public TodoAction addNewTodo(String todoText) {
        LOGGER.info("Adding new todo with text - {}", todoText);
        todoListPage.getNewTodoField().setValue(todoText).pressEnter();
        return this;
    }

    public TodoAction markAsCompleted(String todoText) {
        LOGGER.info("Marking as completed todo with text - {}", todoText);
        todoListPage.getTodoCheckbox(todoText).click();
        return this;
    }

    public TodoAction deleteTodo(String todoText) {
        LOGGER.info("Removing todo with text - {}", todoText);
        todoListPage.getTodoDeleteButton(todoText).click();
        return this;
    }

    public void toggleAllTodo() {
        todoListPage.getToggleAllButton().shouldBe(Condition.visible);
        todoListPage.getToggleAllButton().click();
    }

}
