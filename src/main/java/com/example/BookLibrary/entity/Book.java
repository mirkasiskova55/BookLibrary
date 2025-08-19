package com.example.BookLibrary.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false, unique = true)

    private String isbn;
    @Column(nullable = false)

    private Integer publishedYear;

}
