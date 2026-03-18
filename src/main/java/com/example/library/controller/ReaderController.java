package com.example.library.controller;

import com.example.library.dto.CreateReaderDto;
import com.example.library.dto.response.ReaderResponse;
import com.example.library.service.ReaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;


    @PostMapping("/create")
    ReaderResponse create(@Valid @RequestBody CreateReaderDto createReaderDto) {
        return readerService.createReader(createReaderDto);
    }

    @GetMapping
    List<ReaderResponse> getAll() {
        return readerService.getAllReaders();
    }
}
