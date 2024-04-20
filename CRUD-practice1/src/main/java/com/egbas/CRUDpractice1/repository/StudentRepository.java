package com.egbas.CRUDpractice1.repository;

import com.egbas.CRUDpractice1.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    boolean existsByEmail(String email);
}
