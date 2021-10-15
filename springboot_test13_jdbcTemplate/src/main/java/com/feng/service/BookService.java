package com.feng.service;

import com.feng.entity.Book;

import java.util.List;

public interface BookService {
    int addBook(Book b1);

    int updateBook(Book b2);

    Book getBookById(int i);

    int deleteBookById(int i);

    List<Book> getAllBooks();

}
