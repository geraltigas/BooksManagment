package com.geraltigas.service;

import com.geraltigas.mapper.BookMapper;
import com.geraltigas.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> findAll(){
        return bookMapper.findAll();
    }

    public List<Book> findByName(String name){
        return bookMapper.findByName(name);
    }

    public int updateBook(Book book){
        return bookMapper.updateBook(book.getName(),book.getAuthor(),book.getISBN());
    }

    public int insertBook(Book book){
        return bookMapper.insertBook(book.getName(),book.getAuthor(),book.getISBN());
    }

    public int deleteBook(String name){
        return bookMapper.deleteBook(name);
    }
}
