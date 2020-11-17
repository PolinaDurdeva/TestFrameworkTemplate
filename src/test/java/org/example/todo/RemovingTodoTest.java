package org.example.todo;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.example.action.Navigation;
import org.example.action.TodoAction;
import org.example.base.BaseTest;
import org.testng.annotations.Test;

public class RemovingTodoTest extends BaseTest {

    private final TodoAction baseTodoAction= new TodoAction();
    private final Navigation navigation = new Navigation();

    @Test
    @Description("Verify that a user is able to delete a todo")
    public void testRemoveTodo() {
        final String todoText = "Buy a new book";
        navigation.openTodoPage();
        baseTodoAction.addNewTodo(todoText);
        baseTodoAction
                .getTodoList()
                .shouldHave(CollectionCondition.size(1));
        baseTodoAction
                .deleteTodo(todoText)
                .getTodoList()
                .shouldHave(CollectionCondition.size(0));
    }

}
