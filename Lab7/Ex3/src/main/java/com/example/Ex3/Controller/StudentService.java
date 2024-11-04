package com.example.Ex3.Controller;

import com.example.Ex3.Model.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student student);
    public List<Student> findAll();
    public Student update(Long studentId, Student updatedStudent);
    public void delete(Long studentId);
}
