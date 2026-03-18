package com.example.library.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateReaderDto {

    @NotBlank(message = "Surname cannot be empty")
    private String surname;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Email
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank
    @Size(min = 8, message = "Password must be longer than 8 characters")
    private String password;
}
