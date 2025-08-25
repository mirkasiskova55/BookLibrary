package com.example.BookLibrary.Dto;

import com.example.BookLibrary.entity.BookCopy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookCopyDtoOut {
    private Long id;
    private boolean available;

    public static BookCopyDtoOut mapToDto(BookCopy bookCopy) {
        BookCopyDtoOut dto = new BookCopyDtoOut();
        dto.setId(bookCopy.getId());
        dto.setAvailable(bookCopy.isAvailable());
        return dto;
    }

    public static List<BookCopyDtoOut>mapToDtoList(List<BookCopy> bookCopies){
        return bookCopies.stream()
                .map(BookCopyDtoOut::mapToDto)
                .toList();
    }
}


