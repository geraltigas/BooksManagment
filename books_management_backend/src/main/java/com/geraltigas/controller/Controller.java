package com.geraltigas.controller;

import com.alibaba.fastjson.JSON;
import com.geraltigas.pojo.Book;
import com.geraltigas.service.BookService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Controller {

    private final BookService bookService;

    public Controller(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/findall")
    public String findAll(){
        System.out.println("get all??");
        return JSON.toJSONString(bookService.findAll());
    }
    @RequestMapping("/findbyname/{name}")
    public String findByName(@PathVariable String name){
        return JSON.toJSONString(bookService.findByName(name));
    }

    @RequestMapping("/update")
    public String updateBook(@RequestParam(value = "name") String name,@RequestParam(value = "author") String author,@RequestParam(value = "iSBN") String iSBN)
    {
        System.out.println("into the updateBook");
        Book book = new Book(name,author,iSBN);
        return "" + bookService.updateBook(book);
    }
    @RequestMapping("/insert")
    public  String insertBook(@RequestParam(value = "name") String name,@RequestParam(value = "author") String author,@RequestParam(value = "iSBN") String iSBN){
        Book book = new Book(name,author,iSBN);
        return "" + bookService.insertBook(book);
    }
    @RequestMapping("/deletebyname/{name}")
    public String deleteBook(@PathVariable String name){
        return "" + bookService.deleteBook(name);
    }
}
