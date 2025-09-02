package com.example.BookLibrary.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDtoUpdate extends BookDtoCreate{
    private String title;
    private Integer publishedYear;
}
