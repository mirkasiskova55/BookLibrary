package com.example.BookLibrary.controller;

import com.example.BookLibrary.Dto.BookDtoCreate;
import com.example.BookLibrary.Dto.BookDtoOut;
import com.example.BookLibrary.Dto.BookDtoUpdate;
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
    public List<BookDtoOut> getBooks(){
        return BookDtoOut.mapToDtoList(bookService.findAll());
    }

    @PostMapping("/books")
    public BookDtoOut createBook(@RequestBody BookDtoCreate book){
        return BookDtoOut.mapToDto(bookService.saveBook(book));
    }

    @GetMapping("/books/{id}")
    public BookDtoOut getBook(@PathVariable Long id){
        return BookDtoOut.mapToDto(bookService.findById(id));
    }

    @PostMapping("/books/{id}")
    public BookDtoOut updateBook (@PathVariable Long id, @RequestBody BookDtoUpdate bookDtoUpdate){
        Book book = bookService.updateBook(id,bookDtoUpdate);
        return BookDtoOut.mapToDto(book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook (@PathVariable Long id){
        return bookService.deleteBook(id);
    }

}
