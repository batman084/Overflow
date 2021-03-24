package com.overflow;

import com.calendar.CalendarRequest;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.calendar.CalendarRequest.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
public class OverflowController {

    @GetMapping("/myconnect")
    public String myConnect(Model model) {
        MyConnect test = new MyConnect;
        model.addAttribute("assignment1", test.return1());
        model.addAttribute("assignment2", test.return2());

        return "myconnect";
    }


}
