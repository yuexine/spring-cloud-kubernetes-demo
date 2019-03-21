package com.vcors.demo.serviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/b/{id}")
    public String findById(@PathVariable("id") String id) {
        return "Hi, success get b return.";
    }

}
