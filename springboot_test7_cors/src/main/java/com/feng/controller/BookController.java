package com.feng.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
    public String add(String name) {
        return "receive：" + name;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return String.valueOf(id);
    }
}
