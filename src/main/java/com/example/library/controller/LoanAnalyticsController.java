package com.example.library.controller;

import com.example.library.dto.response.PopularBookDto;
import com.example.library.dto.response.ReaderLoanAnalyticsDto;
import com.example.library.service.LoanAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class LoanAnalyticsController {

    private final LoanAnalyticsService service;

    @GetMapping("/popular-books")
    public List<PopularBookDto> popularBooks(@RequestParam(defaultValue = "10") int limit) {
        return service.getPopularBooks(limit);
    }

    @GetMapping("/reader-loans/{readerId}")
    public List<ReaderLoanAnalyticsDto> loansByReader(@PathVariable Long readerId) {
        return service.getLoansByReader(readerId);
    }
}
