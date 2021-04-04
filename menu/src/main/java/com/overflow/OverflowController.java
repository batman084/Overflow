package com.overflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverflowController {

    @GetMapping("/myconnect")
    public String MyConnect(Model model) {
        MyConnect test = new MyConnect();
        model.addAttribute("assignment1", test.return1());
      //  model.addAttribute("assignment2", test.return2());

        return "myconnect";
    }


}
