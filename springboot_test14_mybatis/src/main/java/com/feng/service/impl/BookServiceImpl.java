package com.feng.service.impl;

import com.feng.entity.Book;
import com.feng.mapper.BookMapper;
import com.feng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int addBook(Book b1) {
        return bookMapper.addBook(b1);
    }

    @Override
    public int updateBook(Book b2) {
        return bookMapper.updateBook(b2);
    }

    @Override
    public Book getBookById(int i) {
        return bookMapper.getBookById(i);
    }

    @Override
    public int deleteBookById(int i) {
        return bookMapper.deleteBookById(i);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }
}
