package com.example.library.repository;

import com.example.library.dto.response.PopularBookDto;
import com.example.library.dto.response.ReaderLoanAnalyticsDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class LoanAnalyticsRepository {

    private final JdbcTemplate jdbcTemplate;

    public LoanAnalyticsRepository(@Qualifier("clickhouseJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PopularBookDto> getPopularBooks(int limit) {
        String sql = """
            SELECT book_id, count(*) as total_loans
            FROM loan_stats
            GROUP BY book_id
            ORDER BY total_loans DESC
            LIMIT ?
        """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> PopularBookDto.builder()
                .bookId(rs.getLong("book_id"))
                .totalLoans(rs.getLong("total_loans"))
                .build(), limit);
    }

    public List<ReaderLoanAnalyticsDto> getLoansByReader(Long readerId) {
        String sql = """
            SELECT book_id, issued_at
            FROM loan_stats
            WHERE reader_id = ?
            ORDER BY issued_at DESC
        """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Timestamp timestamp = rs.getTimestamp("issued_at");
            return ReaderLoanAnalyticsDto.builder()
                    .bookId(rs.getLong("book_id"))
                    .issuedAt(timestamp != null ? timestamp.toLocalDateTime() : null)
                    .build();
        }, readerId);
    }

    public void saveLoanEvent(Long bookId, Long readerId, LocalDateTime issuedAt) {
        String sql = "INSERT INTO loan_stats (book_id, reader_id, issued_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bookId, readerId, Timestamp.valueOf(issuedAt));
    }
}
