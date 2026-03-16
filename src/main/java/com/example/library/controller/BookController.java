package com.example.library.controller;

import com.example.library.dto.BookCreateDto;
import com.example.library.dto.response.BookResponse;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    BookResponse create(@Valid @RequestBody BookCreateDto bookCreateDto){
        return bookService.createBook(bookCreateDto);
    }
}
