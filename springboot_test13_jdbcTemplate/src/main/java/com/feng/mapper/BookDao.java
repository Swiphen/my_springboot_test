package com.feng.mapper;

import com.feng.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addBook(Book book) {
        String sql = "insert into book(name,author) values (?,?)";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor());
    }

    public int updateBook(Book book) {
        String sql = "update book set name=? ,author=? where id=?";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getId());
    }

    public int deleteBookById(Integer id) {
        String sql = "delete from book where id=?";
        return jdbcTemplate.update(sql, id);
    }

    public Book getBookById(Integer id) {
        String sql = "select * from book where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    public List<Book> getAllBooks() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }
}
