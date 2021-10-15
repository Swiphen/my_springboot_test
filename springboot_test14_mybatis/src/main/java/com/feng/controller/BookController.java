package com.feng.controller;

import com.feng.entity.Book;
import com.feng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    public void books() {
        Book b1 = new Book();
        b1.setName("西厢记1");
        b1.setAuthor("王实甫1");
        int i = bookService.addBook(b1);
        System.out.println("addBook >>> " + i);

        Book b2 = new Book();
        b2.setId(1);
        b2.setName("朝花夕拾1");
        b2.setAuthor("鲁迅1");
        int updateBook = bookService.updateBook(b2);
        System.out.println("updateBook >>> " + updateBook);

        Book b3 = bookService.getBookById(1);
        System.out.println("getBookById >>> " + b3);

        int delete = bookService.deleteBookById(2);
        System.out.println("deleteBookById >>> " + delete);

        List<Book> books = bookService.getAllBooks();
        System.out.println("getAllBooks >>>" + books);

    }
}
