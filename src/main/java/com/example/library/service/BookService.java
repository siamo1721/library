package com.example.library.service;

import com.example.library.dto.BookCreateDto;
import com.example.library.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse createBook(BookCreateDto bookCreateDto);

    List<BookResponse> getAllBooks();

    BookResponse findBookByTitle(String title);
}
