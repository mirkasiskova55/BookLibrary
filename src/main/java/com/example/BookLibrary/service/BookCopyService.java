package com.example.BookLibrary.service;

import com.example.BookLibrary.Dto.BookCopyDtoCreate;
import com.example.BookLibrary.Dto.BookCopyDtoUpdate;
import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.entity.BookCopy;
import com.example.BookLibrary.repository.BookCopyRepository;
import com.example.BookLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<BookCopy> findAll(){
        return bookCopyRepository.findAll();    }

    public BookCopy saveBookCopy (Long id,BookCopyDtoCreate in){
        BookCopy bookCopy = new BookCopy();
        Book findBook = bookRepository.findById(id).orElseThrow();
        bookCopy.setBook(findBook);
        bookCopy.setAvailable(in.isAvailable());
        return bookCopyRepository.save(bookCopy);
    }

    public BookCopy updateBookCopy (Long id, BookCopyDtoUpdate bookCopyDtoUpdate){
        BookCopy bookCopy = bookCopyRepository.findById(id).orElseThrow();
        bookCopy.setAvailable(bookCopyDtoUpdate.isAvailable());
        return bookCopyRepository.save(bookCopy);
    }
}
