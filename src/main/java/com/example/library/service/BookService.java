package com.example.library.service;

import com.example.library.dto.CreateBookDto;
import com.example.library.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse createBook(CreateBookDto createBookDto);

    List<BookResponse> getAllBooks();

    BookResponse findBookByTitle(String title);
}
