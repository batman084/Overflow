package com.overflow;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ComponentScan()
public class AppController {
    @GetMapping("/")
    String index() {
        return "index";
    }

    @GetMapping("/MyConnect")
    String MyConnect(Model model) {
        MyConnect test = new MyConnect();
        model.addAttribute("assignment1", test.return1());
       model.addAttribute("assignment2", test.return2());

        model.addAttribute("assignmentLink1", test.return1link());
        model.addAttribute("assignmentLink2", test.return2link());
     //   model.addAttribute("assignment3", test.return3());
        return "MyConnect";
    }
}
