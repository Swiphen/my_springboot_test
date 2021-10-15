package com.feng.controller;

import com.feng.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public ModelAndView book() {
        List<Book> books = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setName("路过的卡面来打");
        b1.setAuthor("王小明");
        Book b2 = new Book();
        b2.setId(2);
        b2.setName("从删库到跑路");
        b2.setAuthor("小斌");
        books.add(b1);
        books.add(b2);
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("book");
        return mv;
    }

    @GetMapping("/json")
    public Book books() {
        Book book = new Book();
        book.setId(1);
        book.setName("路过的卡面来打");
        book.setAuthor("王小明");
        return book;
    }
}
