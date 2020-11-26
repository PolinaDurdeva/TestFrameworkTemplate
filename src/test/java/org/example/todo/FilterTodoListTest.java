package org.example.todo;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Description;
import org.example.action.FilterAction;
import org.example.action.Navigation;
import org.example.action.TodoAction;
import org.example.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterTodoListTest extends BaseTest {

    private final TodoAction baseTodoAction= new TodoAction();
    private final Navigation navigation = new Navigation();
    private final FilterAction filterAction = new FilterAction();

    @BeforeMethod
    public void fillOutTodoList() {
        final String todoText1 = "Buy a new book";
        final String todoText2 = "Cook a dinner";
        final String todoText3 = "Call mom";
        navigation.openTodoPage();
        baseTodoAction
                .addNewTodo(todoText1)
                .addNewTodo(todoText2)
                .addNewTodo(todoText3)
                .markAsCompleted(todoText3);
    }

    @Test
    @Description("Verify that a user is able filter only completed todo")
    public void testFilterCompleted() {
        filterAction.selectCompleted();
        baseTodoAction
                .getTodoList()
                .shouldHave(CollectionCondition.size(1));
    }

    @Test
    @Description("Verify that a user is able filter only active todo")
    public void testFilterActive() {
        filterAction.selectActive();
        baseTodoAction
                .getTodoList()
                .shouldHave(CollectionCondition.size(2));
    }

    @Test
    @Description("Verify that a user is able filter all todo")
    public void testFilterAll() {
        filterAction.selectActive();
        baseTodoAction
                .getTodoList()
                .shouldHave(CollectionCondition.size(2));
        filterAction.selectAll();
        baseTodoAction
                .getTodoList()
                .shouldHave(CollectionCondition.size(3));
    }

}
