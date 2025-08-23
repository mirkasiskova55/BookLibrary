package com.example.BookLibrary.controller;

import com.example.BookLibrary.entity.BookCopy;
import com.example.BookLibrary.repository.BookCopyRepository;
import com.example.BookLibrary.service.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookCopyController {

    @Autowired
    private BookCopyRepository bookCopyRepository;
    @Autowired
    private BookCopyService bookCopyService;

    @PostMapping("/books/{id}/copies")
    public BookCopy createBookCopy(@RequestBody BookCopy  bookCopy){
        return bookCopyService.saveBookCopy(bookCopy);
    }
}




