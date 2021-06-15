package com.overflow;

import com.overflow.todo.data.TodoItem;
import com.overflow.todo.service.TodoService;
import com.overflow.todo.tests.ServiceTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Controller
public class ToDoController implements WebMvcConfigurer {
    final String defaultID = "6936~rffaXRfNKIkE5QgIKa6lsNuIaOh7vxtJSvIRerholiBgbswdHTDpXfX1pNVB5Mf1";
    String titleUpdate, descUpdate;
    int yearUpdate, dateUpdate, monthUpdate, hourUpdate, minUpdate;
    TodoService todoService = new TodoService();

    @GetMapping("/ToDoActivity/ToDoCreate")
    public String todoCreate() {
        TodoItem item = new TodoItem(0, 0, "New Task", "New Task Details", TodoItem.createDate(2021, 6, 15, 10, 00));
        todoService.update(item);
        return "redirect:/ToDoActivity";
    }


/*    @GetMapping("/ToDoActivity/ToDoUpdate/{id}")
    public String todoUpdate(@PathVariable("id") long id, Model model) {
        TodoService todoService = new TodoService();
        TodoItem item = todoService.find((int)id);

        if (item != null) {
            String updateDescription = item.getDescription() + " update";
            TodoItem updatedItem = new TodoItem(item.getId(), item.getUserId(), item.getTitle(), updateDescription, item.getDateTime());
            todoService.update(updatedItem);
        }

        model.addAttribute("id", id);
        model.addAttribute("title", item.getTitle());
        model.addAttribute("description", item.getDescription());

        return "ToDoUpdate";
    }*/

    @GetMapping("/ToDoActivity/ToDoUpdate")
    public String todoUpdatePage(@RequestParam(name = "titleUpdate", defaultValue = "abc") String title,
                                 @RequestParam(name = "descriptionUpdate", defaultValue = "abc") String description,
                                 @RequestParam(name = "yearUpdate", defaultValue = "abc") int year,
                                 @RequestParam(name = "dateUpdate", defaultValue = "abc") int date,
                                 @RequestParam(name = "monthUpdate", defaultValue = "abc") int month,
                                 @RequestParam(name = "hourUpdate", defaultValue = "abc") int hour,
                                 @RequestParam(name = "minUpdate", defaultValue = "abc") int min,
                                 Model model) {
        titleUpdate = title;
        descUpdate = description;
        yearUpdate = year;
        monthUpdate = month;
        dateUpdate = date;
        hourUpdate = hour;
        minUpdate = min;

        return "redirect:/ToDoActivity";
    }

    @GetMapping("/TodoActivity/ToDoUpdate/{id}")
    public String todoUpdate(@PathVariable("id") long id, Model model) {
        TodoItem item = todoService.find((int)id);

        TodoItem todo = new TodoItem(item.getId(), item.getUserId(), titleUpdate, descUpdate, TodoItem.createDate(yearUpdate, monthUpdate, dateUpdate, hourUpdate, minUpdate));
        todoService.update(todo);

        return "redirect:/ToDoActivity";
    }
    @GetMapping("/TodoActivity/ToDoDelete/{id}")
    public String todoDelete(@PathVariable("id") long id) {
        todoService.delete((int)id);
        return "redirect:/ToDoActivity";
    }


    @GetMapping("/ToDoActivity")
    String ToDoActivity(@RequestParam(name = "id4", required = true, defaultValue = defaultID) String id1, Model model) {
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
