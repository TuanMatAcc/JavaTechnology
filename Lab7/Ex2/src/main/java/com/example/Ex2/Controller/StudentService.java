package com.example.Ex2.Controller;

import com.example.Ex2.Model.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student student);
    public List<Student> findAll();
    public Student update(Long studentId, Student updatedStudent);
    public void delete(Long studentId);
}
