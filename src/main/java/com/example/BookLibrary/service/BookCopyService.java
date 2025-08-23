package com.example.BookLibrary.service;

import com.example.BookLibrary.entity.BookCopy;
import com.example.BookLibrary.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;

//    public List<BookCopy>getCopies(){
//        return bookCopyRepository.findAll();
//    }

    public BookCopy saveBookCopy (BookCopy in){
//TODO
        return bookCopyRepository.save(in);
    }
}
