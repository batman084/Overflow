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

@Controller
public class ToDoController implements WebMvcConfigurer {
    @GetMapping("/TodoActivity/ToDoDelete/{id}")
    public String todoDelete(@PathVariable("id") long id) {
        repository.delete(id);
        return "redirect:/ToDoActivity";
    }
}
