package com.example.library.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoanRequestDto {
    @NotNull
    private Long BookId;
    @NotNull
    private Long ReaderId;
}
