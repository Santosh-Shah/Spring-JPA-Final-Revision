package com.example.demo.repository;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("ravitshah@gmail.com")
                .firstName("Ravi")
                .lastName("Shah")
//                .guardianName("Rohit Shah")
//                .guardianEmail("ravishah@gmail.com")
//                .guardianMobile("9817280619")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("rohit679@gmail.com")
                .mobile("9817280619")
                .name("Rohit Shah")
                .build();

        Student student = Student.builder()
                .emailId("ravishah@gmail.com")
                .firstName("Ravi")
                .lastName("Shah")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List: " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> student = studentRepository.findByFirstNameIgnoreCase("ravi");
        System.out.println(student);
    }

    @Test
    public void printStudentByFirstNameCharacter() {
        List<Student> student = studentRepository.findByFirstNameContaining("r");
        System.out.println(student);
    }

}