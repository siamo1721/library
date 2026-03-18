package com.example.library.mapper;

import com.example.library.dto.response.LoanResponse;
import com.example.library.entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "reader.name", target = "readerName")
    LoanResponse toResponse(Loan loan);
}
