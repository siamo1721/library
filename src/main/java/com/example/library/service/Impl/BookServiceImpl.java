package com.example.library.service.Impl;

import com.example.library.dto.BookCreateDto;
import com.example.library.dto.response.BookResponse;
import com.example.library.entity.Book;
import com.example.library.exception.BookAlreadyExistsException;
import com.example.library.mapper.BookMapper;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    @Override
    public BookResponse createBook(BookCreateDto bookCreateDto) {

        if (bookRepository.existsByTitle(bookCreateDto.getTitle())) {
            throw new BookAlreadyExistsException("Book already exists");
        }

        Book book = bookMapper.toEntity(bookCreateDto);

        book.setAvailableCopies(bookCreateDto.getTotalCopies());

        book = bookRepository.save(book);

        return bookMapper.toResponse(book);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return List.of();
    }

    @Override
    public BookResponse findBookByTitle(String title) {
        return null;
    }
}
