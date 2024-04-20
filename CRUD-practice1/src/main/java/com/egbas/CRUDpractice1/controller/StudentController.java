package com.egbas.CRUDpractice1.controller;

import com.egbas.CRUDpractice1.dto.StudentDto;
import com.egbas.CRUDpractice1.entity.Student;
import com.egbas.CRUDpractice1.response.SignUpResponse;
import com.egbas.CRUDpractice1.response.UserDetailsResponse;
import com.egbas.CRUDpractice1.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<UserDetailsResponse> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<UserDetailsResponse> getStudent(@PathVariable Long id){
        UserDetailsResponse student = studentService.getStudentById(id);
        if (student != null){
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/students/add")
    public ResponseEntity<SignUpResponse> addStudent(@Valid @RequestBody StudentDto student){
        SignUpResponse registeredStudent = studentService.addStudent(student);

        return new ResponseEntity<>(registeredStudent, HttpStatus.CREATED);
    }

    @PutMapping("/students/update/{id}")
    public ResponseEntity<UserDetailsResponse> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){

        UserDetailsResponse student = studentService.updateStudent(id, studentDto);
        if (student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);

        return ResponseEntity.ok("Student account deleted successfully!");
    }
}
