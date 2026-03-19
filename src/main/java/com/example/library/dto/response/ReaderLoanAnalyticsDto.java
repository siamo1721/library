package com.example.library.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReaderLoanAnalyticsDto {
    private Long bookId;
    private LocalDateTime issuedAt;
}

