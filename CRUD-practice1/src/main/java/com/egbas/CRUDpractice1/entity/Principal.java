package com.egbas.CRUDpractice1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "principal_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Principal extends BaseClass{

    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String password;
}
