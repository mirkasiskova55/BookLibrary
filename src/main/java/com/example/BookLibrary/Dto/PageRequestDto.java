package com.example.BookLibrary.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequestDto {
    private Integer page;
    private Integer size;
    private String sort;
    private String direction;
}
