package com.example.BookLibrary.repository;

import com.example.BookLibrary.entity.Book;
import com.example.BookLibrary.entity.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {
}
