package com.example.BookLibrary.service;

import com.example.BookLibrary.Dto.BookDtoCreate;
import com.example.BookLibrary.Dto.BookDtoUpdate;
import com.example.BookLibrary.Dto.PageRequestDto;
import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//    public List<Book> findAll(){
//        return bookRepository.findAll();
//    }

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
    public Page<Book> findAll(PageRequestDto pageRequestDto) {
        Pageable pageable = createPageable(pageRequestDto);
        return bookRepository.findAll(pageable);
    }


    private PageRequest createPageable(PageRequestDto pageRequestDto) {
        int page = pageRequestDto.getPage() != null ? pageRequestDto.getPage() : 0;
        int size = pageRequestDto.getSize() != null ? pageRequestDto.getSize() : 10;

        if (pageRequestDto.getSort() != null && pageRequestDto.getDirection() != null) {
            Sort sort = Sort.by(
                    Sort.Direction.fromString(pageRequestDto.getDirection()),
                    pageRequestDto.getSort()
            );
            return PageRequest.of(page, size, sort);
        } else {
            return PageRequest.of(page, size);
        }
    }

}
