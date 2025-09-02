package com.example.BookLibrary.controller;

import com.example.BookLibrary.Dto.BookCopyDtoCreate;
import com.example.BookLibrary.Dto.BookCopyDtoOut;
import com.example.BookLibrary.Dto.BookCopyDtoUpdate;
import com.example.BookLibrary.entity.BookCopy;
import com.example.BookLibrary.repository.BookCopyRepository;
import com.example.BookLibrary.service.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookCopyController {

    @Autowired
    private BookCopyRepository bookCopyRepository;
    @Autowired
    private BookCopyService bookCopyService;

    @GetMapping("/books/{id}/copies")
    public List<BookCopyDtoOut> getCopies(@PathVariable Long id){
        return BookCopyDtoOut.mapToDtoList(bookCopyService.findAll());
    }

    @PostMapping("/books/{id}/copies")
    public BookCopyDtoOut createBookCopy(@PathVariable Long id, @RequestBody BookCopyDtoCreate bookCopy){
        return BookCopyDtoOut.mapToDto(bookCopyService.saveBookCopy(id, bookCopy));
    }

    @PostMapping("/books/{id}/copies/{copyId}")
    public BookCopyDtoOut updateBookCopy(@PathVariable Long id, @RequestBody BookCopyDtoUpdate bookCopyDtoUpdate){
        BookCopy bookcopy = bookCopyService.updateBookCopy(id,bookCopyDtoUpdate);
        return BookCopyDtoOut.mapToDto(bookcopy);
    }
}




