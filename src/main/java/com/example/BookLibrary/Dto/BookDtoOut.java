package com.example.BookLibrary.Dto;

import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.entity.BookCopy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDtoOut {
    private String title;
    private Integer publishedYear;
    private String author;
    private String isbn;
    private List<BookCopyDtoOut> copies;

 public static BookDtoOut mapToDto(Book book){
     BookDtoOut dto = new BookDtoOut();
     dto.setTitle(book.getTitle());
     dto.setPublishedYear(book.getPublishedYear());
     dto.setIsbn(book.getIsbn());
     dto.setAuthor(book.getAuthor());
     if (book.getCopies() != null) {
         dto.setCopies(BookCopyDtoOut.mapToDtoList(book.getCopies()));
     } else {
         dto.setCopies(List.of()); // prázdny zoznam namiesto null
     }
    return dto;
 }
 public static List<BookDtoOut>mapToDtoList(List<Book> books){
     return books.stream()
             .map(BookDtoOut::mapToDto)
             .toList();
 }
}
