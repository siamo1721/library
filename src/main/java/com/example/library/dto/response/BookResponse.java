package com.example.library.dto.response;

import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String author;
    private String title;
    private String isbnNum;
    private Integer year;
}
