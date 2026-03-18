package com.example.library.controller;

import com.example.library.dto.BookCreateDto;
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
    BookResponse create(@Valid @RequestBody BookCreateDto bookCreateDto){
        return bookService.createBook(bookCreateDto);
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
