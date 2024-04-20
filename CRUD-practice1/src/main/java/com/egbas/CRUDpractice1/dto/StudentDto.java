package com.egbas.CRUDpractice1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {

    private Long id;


    @Size(min = 2, max = 20, message = "Firstname should be between 6 and 20 characters")
    @NotBlank(message = "Firstname must not be blank")
    private String firstName;

    @Size(min = 6, max = 20, message = "Lastname should be between 6 and 20 characters")
    @NotBlank(message = "Lastname must not be blank")
    private String lastName;

    @NotBlank(message = "Age must not be blank")
    private String age;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 6, max = 20, message = "Password should be between 6 and 20 characters")
    @NotBlank(message = "Password must not be blank")
    private String password;

    @Size(min = 6, max = 20, message = "Confirm password must be exact as password")
    @NotBlank(message = "Password must not be blank")
    private String ConfirmPassword;


}
