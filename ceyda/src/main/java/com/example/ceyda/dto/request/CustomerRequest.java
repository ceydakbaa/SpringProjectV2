package com.example.ceyda.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @NotEmpty(message = "Firstname can not be empty")
    private String firstName;
    private String lastName;

    @Email(message = "Please enter a valid email address")
    private String email;

    @Size(min = 6, max = 15)
    @NotNull(message = "Please enter a valid password ")
    private String password;

    @Pattern(regexp = "^[0-9]{11}$", message = "Must consist of 11 digits")
    private String phoneNumber;

}
