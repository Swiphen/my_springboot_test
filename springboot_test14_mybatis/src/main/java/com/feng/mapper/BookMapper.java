package com.feng.mapper;

import com.feng.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface BookMapper {

    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(Integer id);

    Book getBookById(Integer id);

    List<Book> getAllBooks();
}
