package com.overflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OverflowController {

    @GetMapping("/myconnect")
    public String ApiCall(Model model) {
        ApiCall test = new ApiCall();
        model.addAttribute("assignment1", test.return1());
        return "myconnect";
    }
}