package com.example.BookLibrary.Dto;

import com.example.BookLibrary.entity.BookCopy;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDtoCreate {
    @NotNull
    private String title;
    private Integer publishedYear;
    private String author;
    private String isbn;
    private List<BookCopyDtoOut> copies;

}
