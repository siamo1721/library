package com.example.library.mapper;

import com.example.library.dto.CreateReaderDto;
import com.example.library.dto.response.ReaderResponse;
import com.example.library.entity.Reader;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    Reader toEntity(CreateReaderDto createReaderDto);

    ReaderResponse toResponse(Reader reader);
}
