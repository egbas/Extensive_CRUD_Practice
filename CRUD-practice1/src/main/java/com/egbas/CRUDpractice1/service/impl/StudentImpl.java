package com.egbas.CRUDpractice1.service.impl;

import com.egbas.CRUDpractice1.dto.StudentDto;
import com.egbas.CRUDpractice1.entity.Student;
import com.egbas.CRUDpractice1.repository.StudentRepository;
import com.egbas.CRUDpractice1.response.SignUpResponse;
import com.egbas.CRUDpractice1.response.UserDetailsResponse;
import com.egbas.CRUDpractice1.service.StudentService;
import com.egbas.CRUDpractice1.utils.RegistrationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public List<UserDetailsResponse> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        return convertToRequiredType(studentList);
    }

    @Override
    public UserDetailsResponse getStudentById(Long id) {
// Throw and exception if ID is not found... Do that later
        Student student = studentRepository.findById(id).get();

        // if the return type was a dto this below could suffice
//        StudentDto student = studentRepository.findById(id).get();

        return UserDetailsResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .email(student.getEmail())
                .build();
    }

    @Override
    public SignUpResponse addStudent(StudentDto studentDto) {

// This is to ensure no proper validation and no field is missing during registration
        if (studentDto.getFirstName() == null || studentDto.getFirstName().isEmpty() ||
                studentDto.getLastName() == null || studentDto.getLastName().isEmpty() ||
                studentDto.getAge() == null || studentDto.getAge().isEmpty() ||
                studentDto.getEmail() == null || studentDto.getEmail().isEmpty() ||
                studentDto.getPassword() == null || studentDto.getPassword().isEmpty()
        ){
            return SignUpResponse.builder()
                    .responseCode(RegistrationUtils.INVALID_DETAILS_ENTERED_CODE)
                    .responseMessage(RegistrationUtils.INVALID_DETAILS_ENTERED_MESSAGE)
                    .build();
        }

        // This is to ensure that the password wasn't entered by mistake
        if (!studentDto.getPassword().equals(studentDto.getConfirmPassword())){

            return SignUpResponse.builder()
                    .responseCode(RegistrationUtils.PASSWORD_MISMATCH_CODE)
                    .responseMessage(RegistrationUtils.PASSWORD_MISMATCH_MESSAGE)
                    .build();
        }

        // This is used to check if the user exists to avoid creation of duplicate accounts
        if (studentRepository.existsByEmail(studentDto.getEmail())){
            return SignUpResponse.builder()
                    .responseCode(RegistrationUtils.EXISTING_USER_CODE)
                    .responseMessage(RegistrationUtils.EXISTING_USER_MESSAGE)
                    .build();
        }

        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .age(studentDto.getAge())
                .email(studentDto.getEmail())
                .password(studentDto.getPassword())
                .build();

        studentRepository.save(student);

        return SignUpResponse.builder()
                .responseCode(RegistrationUtils.REGISTRATION_SUCCESS_CODE)
                .responseMessage(RegistrationUtils.REGISTRATION_SUCCESS_MESSAGE)
                .build();
    }

    @Override
    public UserDetailsResponse updateStudent(Long id, StudentDto studentDto) {

        // The .get() method is an optional method... A proper exception can still be thrown. go and learn how
        Student student = studentRepository.findById(id).get();

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());

        studentRepository.save(student);

        // This can be done if you want to return a dto with an updated ID
//        Student editedStudent = studentRepository.save(student);
//        studentDto.setId(editedStudent.getId());

        //It is however good practice to always return a response entity instead of exposing all dto details
        // Any detail not set would be return as a null response so using a customized response is better
        // Here you'll decide what exactly you want the user to see

        return UserDetailsResponse.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(student.getAge())
                .email(student.getEmail())
                .build();

        // You can also decide to use only response code and response message format like was used for register
        // It won't return details but would give necessary information that the update has been performed
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).get();

        studentRepository.delete(student);
    }


    // This is a template for conversion of one type to another or a list
    // th below converted to userdetails... it can be to dto or anyother type
    private List<UserDetailsResponse> convertToRequiredType(List<Student> students) {
        List<UserDetailsResponse> list = new ArrayList<>();

        for(Student student : students){
            UserDetailsResponse response = UserDetailsResponse.builder()
                    .id(student.getId())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .age(student.getAge())
                    .email(student.getEmail())
                    .build();


            list.add(response);
        }

        return list;
    }

    private StudentDto convertToDTO(Student students) {
        StudentDto dto = StudentDto.builder()
                .id(students.getId())
                .firstName(students.getFirstName())
                .lastName(students.getLastName())
                .email(students.getEmail())
                .password(students.getPassword())
                .build();


        return dto;
    }


}
