package com.overflow.main.todo.tests;

import com.overflow.main.todo.data.TodoItem;

public class TodoItemTest {
    public static void run() {
        System.out.println("Running To Do Items tests...");
        testConstructor();
    }

    private static void testConstructor() {
        TodoItem item = new TodoItem(0, 0, "todo 1", "todo 1 details", TodoItem.createDate(2021, 12, 20, 13, 30));

        System.out.println(item);
    }
}
