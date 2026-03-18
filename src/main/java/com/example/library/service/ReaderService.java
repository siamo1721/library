package com.example.library.service;

import com.example.library.dto.CreateReaderDto;
import com.example.library.dto.response.ReaderResponse;

import java.util.List;

public interface ReaderService {

    ReaderResponse createReader (CreateReaderDto createReaderDto);
    List<ReaderResponse> getAllReaders();
}
