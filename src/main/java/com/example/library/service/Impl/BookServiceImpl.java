package com.example.library.service.Impl;

import com.example.library.dto.CreateBookDto;
import com.example.library.dto.response.BookResponse;
import com.example.library.entity.Book;
import com.example.library.exception.AlreadyExistsException;
import com.example.library.exception.NotFoundException;
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
    public BookResponse createBook(CreateBookDto createBookDto) {

        if (bookRepository.existsByTitle(createBookDto.getTitle())) {
            throw new AlreadyExistsException("Book already exists");
        }

        Book book = bookMapper.toEntity(createBookDto);

        book.setAvailableCopies(createBookDto.getTotalCopies());

        book = bookRepository.save(book);

        return bookMapper.toResponse(book);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toResponse)
                .toList();
    }

    @Override
    public BookResponse findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title)
                .orElseThrow(() -> new NotFoundException("Book not found"));
        return bookMapper.toResponse(book);
    }
}
