package com.example.BookLibrary.service;

import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book saveBook (Book in){
        return bookRepository.save(in);
    }

    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow();
    }
}
