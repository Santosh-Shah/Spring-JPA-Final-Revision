package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameIgnoreCase(String firstName);
    public List<Student> findByFirstNameContaining(String character);
    public List<Student> findByFirstNameContainingIgnoreCase(String character);
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);


    // JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // Native Query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    // Native Param Query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNameParam(@Param("emailId") String emailId);

}
