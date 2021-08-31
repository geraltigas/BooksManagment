package com.geraltigas.mapper;

import com.geraltigas.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookMapper {

    @Delete("delete from booksdb.books where name = #{name}")
    int deleteBook(String name);

    @Insert("insert into booksdb.books (name,author,ISBN) values (#{name} , #{author} , #{ISBN})")
    int insertBook(String name,String author,String ISBN);

    @Update("update booksdb.books set name = #{name} , author = #{author}, ISBN = #{ISBN} where name = #{name}")
    int updateBook(String name,String author,String ISBN);

    @Select("select * from booksdb.books where name = #{name}")
    List<Book> findByName(String name);

    @Select("select * from booksdb.books")
    List<Book> findAll();
}
