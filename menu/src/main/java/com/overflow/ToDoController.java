package com.overflow;

import com.overflow.todo.data.TodoItem;
import com.overflow.todo.service.TodoService;
import com.overflow.todo.tests.ServiceTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Calendar;

@Controller
public class ToDoController implements WebMvcConfigurer {
    final String defaultID = "6936~rffaXRfNKIkE5QgIKa6lsNuIaOh7vxtJSvIRerholiBgbswdHTDpXfX1pNVB5Mf1";

    @GetMapping("/ToDoActivity/ToDoCreate")
    public String todoCreate() {
        TodoService todoService = new TodoService();

        TodoItem item = new TodoItem(0, 0, "New Task", "New Task Details", TodoItem.createDate(2021, 6, 15, 10, 00));
        todoService.update(item);
        return "redirect:/ToDoActivity";
    }

    @GetMapping("/ToDoActivity/ToDoUpdate/{id}")
    public String todoUpdate(@PathVariable("id") long id) {
        TodoService todoService = new TodoService();
        TodoItem item = todoService.find((int)id);

        if (item != null) {
            String updateDescription = item.getDescription() + " update";
            TodoItem updatedItem = new TodoItem(item.getId(), item.getUserId(), item.getTitle(), updateDescription, item.getDateTime());
            todoService.update(updatedItem);
        }

        return "redirect:/ToDoActivity";
    }

    @GetMapping("/TodoActivity/ToDoDelete/{id}")
    public String todoDelete(@PathVariable("id") long id) {
        TodoService todoService = new TodoService();
        todoService.delete((int)id);
        return "redirect:/ToDoActivity";
    }

    @GetMapping("/ToDoActivity")
    String ToDoActivity(@RequestParam(name = "id4", required = true, defaultValue = defaultID) String id1, Model model) {

        TodoService todoService = new TodoService();
        ArrayList<TodoItem> items = todoService.find();

        model.addAttribute("todos", items);

        return "ToDoActivity";
    }

    @GetMapping("/ToDoActivity/ToDoGenerateTest")
    String ToDoGenerateTest(@RequestParam(name = "id4", required = true, defaultValue = defaultID) String id1, Model model) {

        // get items from a test
        ServiceTest.generateSampleItems();

        TodoService todoService = new TodoService();
        ArrayList<TodoItem> items = todoService.find();

        model.addAttribute("todos", items);

        // but it's possible to update and find items like this
/*
        TodoService todoService = new TodoService();
        todoService.update(new TodoItem(0, 0, "todo 2", "todo 3 details", TodoItem.createDate(2021, 1, 2, 10, 30)));
        todoService.find(1);
*/


        return "ToDoActivity";
    }
}
