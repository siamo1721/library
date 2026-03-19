package com.example.library.service;

import com.example.library.dto.response.PopularBookDto;
import com.example.library.dto.response.ReaderLoanAnalyticsDto;

import java.util.List;

public interface LoanAnalyticsService {
    List<PopularBookDto> getPopularBooks(int limit);
    List<ReaderLoanAnalyticsDto> getLoansByReader(Long readerId);
}

