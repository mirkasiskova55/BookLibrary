package com.example.BookLibrary.Dto;

import com.example.BookLibrary.entity.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCopyDtoUpdate extends BookCopyDtoCreate {
    @Column(nullable = false)
    private boolean available = true;
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    @JsonIgnore
    private Book book;
}
