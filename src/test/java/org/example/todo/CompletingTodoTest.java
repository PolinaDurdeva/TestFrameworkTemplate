package org.example.todo;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Description;
import org.example.action.Navigation;
import org.example.action.TodoAction;
import org.example.base.BaseTest;
import org.testng.annotations.Test;

public class CompletingTodoTest extends BaseTest {

    private final TodoAction baseTodoAction= new TodoAction();
    private final Navigation navigation = new Navigation();

    @Test
    @Description("Verify that a user is able to complete a todo")
    public void testMarkTodoAsCompleted() {
        final String todoText = "Buy a new book";
        navigation.openTodoPage();
        baseTodoAction.addNewTodo(todoText);
        baseTodoAction
                .getCompleted()
                .shouldHave(CollectionCondition.size(0));
        baseTodoAction
                .markAsCompleted(todoText)
                .getCompleted()
                .shouldHave(CollectionCondition.size(1));
    }

    @Test
    @Description("Verify that a user is able to complete all todo with one click")
    public void testCompletedAllTodo() {
        final String todoText = "Buy a new book";
        final String todoText2 = "Cook a dinner";
        navigation.openTodoPage();
        baseTodoAction
                .addNewTodo(todoText)
                .addNewTodo(todoText2);
        baseTodoAction
                .getCompleted()
                .shouldHave(CollectionCondition.size(0));
        baseTodoAction
                .toggleAllTodo()
                .getCompleted()
                .shouldHave(CollectionCondition.size(2));
    }

}
