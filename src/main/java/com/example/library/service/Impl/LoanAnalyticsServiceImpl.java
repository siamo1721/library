package com.example.library.service.Impl;

import com.example.library.dto.response.PopularBookDto;
import com.example.library.dto.response.ReaderLoanAnalyticsDto;
import com.example.library.repository.LoanAnalyticsRepository;
import com.example.library.service.LoanAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanAnalyticsServiceImpl implements LoanAnalyticsService {

    private final LoanAnalyticsRepository repository;

    @Override
    public List<PopularBookDto> getPopularBooks(int limit) {
        return repository.getPopularBooks(limit);
    }

    @Override
    public List<ReaderLoanAnalyticsDto> getLoansByReader(Long readerId) {
        return repository.getLoansByReader(readerId);
    }
}

