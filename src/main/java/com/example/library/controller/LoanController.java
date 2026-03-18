package com.example.library.controller;

import com.example.library.dto.LoanRequestDto;
import com.example.library.dto.response.LoanResponse;
import com.example.library.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/issue")
    public LoanResponse issueBook(@Valid @RequestBody LoanRequestDto loanRequestDto) {
        return loanService.issueBook(loanRequestDto);
    }

    @PostMapping("/return/{loanId}")
    public LoanResponse returnBook(@PathVariable Long loanId) {
        return loanService.returnedBook(loanId);
    }

    @GetMapping("/reader/{readerId}")
    public List<LoanResponse> getLoansByReader(@PathVariable Long readerId) {
        return loanService.getLoansByReader(readerId);
    }
}
