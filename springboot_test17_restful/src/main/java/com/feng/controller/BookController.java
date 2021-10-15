package com.feng.controller;

import com.feng.BookRepository;
import com.feng.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public Book addBook(Book book) {
        Book save = bookRepository.save(book);
        return save;
    }

    @GetMapping("/books/{id}")
    public Book getById(@PathVariable("id") Integer id) {
        Book book = bookRepository.findById(id).get();
        return book;
    }

    @RequestMapping("/getAll")
    public List<Book> getAll() {
        List<Book> list = bookRepository.findAll();
        return list;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
        return "删除成功！";
    }
}
