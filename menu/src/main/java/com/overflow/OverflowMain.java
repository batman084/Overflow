package com.overflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
public class OverflowMain {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        SpringApplication.run(OverflowController.class, args);
    }
}
