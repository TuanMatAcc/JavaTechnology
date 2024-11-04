package com.example.Ex4.Controller;

import com.example.Ex4.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    public List<Student> findStudentsByAgeGreaterThanEqual(int age);
    public List<Student> findStudentsByIeltsScoreEquals(double score);
    public List<Student> findStudentsByNameContainingIgnoreCase(String subString);
}
