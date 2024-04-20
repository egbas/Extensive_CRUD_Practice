package com.egbas.CRUDpractice1.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String age;
    private String email;
}
