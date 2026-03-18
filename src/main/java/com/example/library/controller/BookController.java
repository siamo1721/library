package com.example.library.controller;

import com.example.library.dto.CreateBookDto;
import com.example.library.dto.response.BookResponse;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    BookResponse create(@Valid @RequestBody CreateBookDto createBookDto){
        return bookService.createBook(createBookDto);
    }

    @GetMapping()
    List<BookResponse> getAll(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{title}")
    BookResponse getBook(@Valid @PathVariable String title) {
        return bookService.findBookByTitle(title);
    }
}
