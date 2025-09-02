package com.example.BookLibrary.service;

import com.example.BookLibrary.Dto.BookDtoCreate;
import com.example.BookLibrary.Dto.BookDtoUpdate;
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

    public Book saveBook (BookDtoCreate in){
        Book book = new Book();
        book.setTitle(in.getTitle());
        book.setAuthor(in.getAuthor());
        book.setIsbn(in.getIsbn());
        book.setPublishedYear(in.getPublishedYear());
        return bookRepository.save(book);
    }

    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    public Book updateBook(Long id, BookDtoUpdate bookDtoUpdate ) {
        Book updateBook = bookRepository.findById(id).orElseThrow();
        updateBook.setTitle(bookDtoUpdate.getTitle());
        updateBook.setPublishedYear(bookDtoUpdate.getPublishedYear());
        return bookRepository.save(updateBook);
    }

    public String deleteBook (Long id){
        bookRepository.deleteById(id);
        return "Book deleted";
    }


}
