package com.egbas.CRUDpractice1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher_tbl")

public class Teacher extends BaseClass{

    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String password;
    private String subject;
}
