package com.example.library.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanResponse {
    private Long id;
    private String bookTitle;
    private String readerName;
    private LocalDateTime issuedAt;
    private LocalDateTime returnedAt;
}
