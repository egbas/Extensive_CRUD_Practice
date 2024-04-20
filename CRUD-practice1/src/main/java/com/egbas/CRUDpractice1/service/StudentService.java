package com.egbas.CRUDpractice1.service;

import com.egbas.CRUDpractice1.dto.StudentDto;
import com.egbas.CRUDpractice1.entity.Student;
import com.egbas.CRUDpractice1.response.SignUpResponse;
import com.egbas.CRUDpractice1.response.UserDetailsResponse;

import java.util.List;

public interface StudentService {

    List<UserDetailsResponse> getAllStudent();

    public UserDetailsResponse getStudentById(Long id);

    public SignUpResponse addStudent(StudentDto studentDto);

    public UserDetailsResponse updateStudent(Long id, StudentDto studentDto);

    void deleteStudent(Long id);
}
