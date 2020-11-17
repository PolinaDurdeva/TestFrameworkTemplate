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
    @Description("Verify that a user is able to delete a todo")
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

}
