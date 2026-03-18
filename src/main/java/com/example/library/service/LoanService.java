package com.example.library.service;

import com.example.library.dto.LoanRequestDto;
import com.example.library.dto.response.LoanResponse;

import java.util.List;

public interface LoanService {

    LoanResponse issueBook(LoanRequestDto loanRequestDto);

    LoanResponse returnedBook(Long loanId);

    List<LoanResponse> getLoansByReader(Long readerId);

}
