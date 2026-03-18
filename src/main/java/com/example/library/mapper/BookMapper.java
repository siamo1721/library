package com.example.library.mapper;

import com.example.library.dto.CreateBookDto;
import com.example.library.dto.response.BookResponse;
import com.example.library.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(CreateBookDto request);

    BookResponse toResponse(Book book);
}
