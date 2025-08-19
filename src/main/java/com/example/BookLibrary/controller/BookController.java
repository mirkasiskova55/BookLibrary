package com.example.BookLibrary.controller;

import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.repository.BookRepository;
import com.example.BookLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.findAll();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.findById(id);
    }


}
