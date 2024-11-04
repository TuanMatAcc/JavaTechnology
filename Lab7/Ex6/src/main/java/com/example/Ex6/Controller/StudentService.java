package com.example.Ex6.Controller;

import com.example.Ex6.Model.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student student);
    public List<Student> findAll();
    public Student update(Long studentId, Student updatedStudent);
    public void delete(Long studentId);

    public List<Student> getStudentAgeGreaterOrEqual(int age);
    public List<Student> getStudentsIeltsScoreEqual(double score);
    public List<Student> getStudentsNameContainingWord(String subString);
}
