package org.example.todo;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Description;
import org.example.action.TodoAction;
import org.example.action.Navigation;
import org.example.base.BaseTest;
import org.testng.annotations.Test;

public class AddingNewTodoTest extends BaseTest {

    private final TodoAction baseTodoAction= new TodoAction();
    private final Navigation navigation = new Navigation();

    @Test
    @Description("Verify that a user is able to add new todo")
    public void testAddNewTodo() {
        final String todoText = "Buy a new book";
        navigation.openTodoPage();
        baseTodoAction
                .getTodoList()
                .shouldHave(CollectionCondition.size(0));
        baseTodoAction
                .addNewTodo(todoText)
                .getTodoList()
                .shouldHave(CollectionCondition.size(1));
    }

}
