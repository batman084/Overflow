package com.overflow.todo.tests;

import com.overflow.todo.data.TodoItem;
import com.overflow.todo.database.DbConnection;
import com.overflow.todo.service.TodoService;

import java.util.ArrayList;

public class ServiceTest {
    public static void run() {
        System.out.println("Running To Do Service tests...");
        runTests();
    }

    private static void runTests() {
        // create in working directory folder with a specific name
        DbConnection db = DbConnection.createConnection("", "serviceTest.db");

        TodoService service = new TodoService(db);

        System.out.println("inserting 4 items for default user and 1 item for a different user...");
        service.update(new TodoItem(0, 0, "todo 1", "todo 1 details", TodoItem.createDate(2021, 1, 1, 13, 30)));
        service.update(new TodoItem(0, 0, "todo 2", "todo 2 details", TodoItem.createDate(2021, 1, 1, 14, 30)));
        service.update(new TodoItem(0, 0, "todo 2", "todo 3 details", TodoItem.createDate(2021, 1, 2, 10, 30)));
        service.update(new TodoItem(0, 0, "todo 2", "todo 4 details", TodoItem.createDate(2021, 1, 3, 9, 0)));
        service.update(new TodoItem(0, 1, "", "", TodoItem.createDate(2021, 1, 3, 9, 0)));

        // updating item
        service.update(new TodoItem(2, 0, "todo 2 x", "todo 2 details updated", TodoItem.createDate(2021, 1, 1, 14, 30)));

        System.out.println("Looking for all items of a default user...");
        ArrayList<TodoItem> items = service.find();
        System.out.println("Expected 4 items and found: " + items.size());

        System.out.println("Looking for item with id 1...");
        TodoItem item = service.find(1);
        System.out.println("found:\n" + item);

        System.out.println("Looking for items with a specific date...");
        items = service.find(TodoItem.createDate(2021, 1, 1, 0, 0));
        System.out.println("expected 2 items and found: " + items.size());

        System.out.println("Looking for items after a specific date...");
        items = service.find(TodoItem.createDate(2021, 1, 2, 0, 0));
        System.out.println("expected 1 items and found: " + items.size());
    }

    public static void generateSampleItems() {
        DbConnection db = DbConnection.createConnection();

        TodoService service = new TodoService(db);

        System.out.println("inserting 4 items for default user and 1 item for a different user...");
        service.update(new TodoItem(0, 0, "(1) Math", "Math assignment is due", TodoItem.createDate(2020, 6, 15, 13, 30)));
        service.update(new TodoItem(0, 0, "(2) Biology", "Biology assignment is due", TodoItem.createDate(2020, 6, 15, 14, 30)));
        service.update(new TodoItem(0, 0, "(3) Chemistry", "Chemistry assignment is due", TodoItem.createDate(2020, 6, 15, 10, 30)));
        service.update(new TodoItem(0, 0, "(4) Physics", "Physics assignment is due", TodoItem.createDate(2020, 6, 16, 9, 0)));
        service.update(new TodoItem(0, 1, "Another Assignment", "An assignment for another user", TodoItem.createDate(2020, 1, 3, 9, 0)));
    }
}
