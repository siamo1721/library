package com.example.library.repository;

import com.example.library.entity.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(@NotBlank(message = "Title cannot be empty") @Size(max = 100) String title);
}
