package com.example.library.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "reader_id")
    private Reader reader;

    private LocalDateTime issuedAt;

    private LocalDateTime returnedAt;
}
