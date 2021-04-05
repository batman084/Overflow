package com.overflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class OverflowMain {
    public static void main(String[] args) {
        SpringApplication.run(OverflowMain.class, args);
    }

    @GetMapping("/myconnect")
    public String ApiCall(Model model) {
        ApiCall test = new ApiCall();
        model.addAttribute("assignment1", test.return1());
        return "myconnect";
    }

}