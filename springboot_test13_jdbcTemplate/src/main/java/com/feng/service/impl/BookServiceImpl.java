package com.feng.service.impl;

import com.feng.entity.Book;
import com.feng.mapper.BookDao;
import com.feng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public int addBook(Book b1) {
        return bookDao.addBook(b1);
    }

    @Override
    public int updateBook(Book b2) {
        return bookDao.updateBook(b2);
    }

    @Override
    public Book getBookById(int i) {
        return bookDao.getBookById(i);
    }

    @Override
    public int deleteBookById(int i) {
        return bookDao.deleteBookById(i);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}
