package com.overflow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OverflowController {

    @GetMapping("/myconnect")
    public String MyConnect(@RequestParam(name="assignment",required=true) Model model) {
        MyConnect test = new MyConnect();
        model.addAttribute("assignment1", test.return1());
      //  model.addAttribute("assignment2", test.return2());

        return "myconnect";
    }


}
