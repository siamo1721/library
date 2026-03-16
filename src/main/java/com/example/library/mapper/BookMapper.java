package com.example.library.mapper;

import com.example.library.dto.BookCreateDto;
import com.example.library.dto.response.BookResponse;
import com.example.library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {


    @Mapping(source = "isbnNum", target = "isbnNum")
    @Mapping(source = "totalCopies", target = "totalCopies")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "year", target = "year")
    Book toEntity(BookCreateDto request);

    @Mapping(source = "isbnNum", target = "isbnNum")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "year", target = "year")
    BookResponse toResponse(Book book);
}
