package com.egbas.CRUDpractice1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
