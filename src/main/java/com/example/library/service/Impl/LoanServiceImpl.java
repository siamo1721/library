package com.example.library.service.Impl;

import com.example.library.dto.LoanRequestDto;
import com.example.library.dto.response.LoanResponse;
import com.example.library.entity.Book;
import com.example.library.entity.Loan;
import com.example.library.entity.Reader;
import com.example.library.exception.AlreadyIssuedException;
import com.example.library.exception.NotFoundException;
import com.example.library.mapper.LoanMapper;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanAnalyticsRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.ReaderRepository;
import com.example.library.service.LoanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;
    private final LoanAnalyticsRepository loanAnalyticsRepository;
    private final LoanMapper loanMapper;


    @Transactional
    @Override
    public LoanResponse issueBook(LoanRequestDto loanRequestDto) {

        Reader reader = readerRepository.findById(loanRequestDto.getReaderId())
                .orElseThrow(() -> new NotFoundException("Reader not found"));
        Book book = bookRepository.findById(loanRequestDto.getBookId())
                .orElseThrow(() -> new NotFoundException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new AlreadyIssuedException("There are no books left");
        }

        Loan loan = Loan.builder()
                .book(book)
                .reader(reader)
                .issuedAt(LocalDateTime.now())
                .build();

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        bookRepository.save(book);
        loan = loanRepository.save(loan);

        loanAnalyticsRepository.saveLoanEvent(book.getId(), reader.getId(), loan.getIssuedAt());

        return loanMapper.toResponse(loan);
    }

    @Transactional
    @Override
    public LoanResponse returnedBook(Long loanId) {

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new NotFoundException("Loan not found"));

        if (loan.getReturnedAt() != null) {
            throw new AlreadyIssuedException("Book already returned");
        }

        loan.setReturnedAt(LocalDateTime.now());
        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        bookRepository.save(book);
        loan = loanRepository.save(loan);

        return loanMapper.toResponse(loan);
    }

    @Override
    public List<LoanResponse> getLoansByReader(Long readerId) {
        return loanRepository.findByReaderIdAndReturnedAtIsNull(readerId)
                .stream()
                .map(loanMapper::toResponse)
                .toList();
    }
}
