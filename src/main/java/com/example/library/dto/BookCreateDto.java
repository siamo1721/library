package com.example.library.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BookCreateDto {

    @NotBlank(message = "Author cannot be empty")
    @Size(max = 100)
    private String author;
    @NotBlank(message = "Title cannot be empty")
    @Size(max = 200)
    private String title;
    @NotNull
    @Min(value = 1, message = "Copies must be at least 1")
    @Max(value = 1000)
    private Integer totalCopies;
    @NotNull(message = "ISBN cannot be null")
    private String isbnNum;
    @NotNull
    @Min(value = 1, message = "Copies must be at least 1")
    private Integer year;

}
