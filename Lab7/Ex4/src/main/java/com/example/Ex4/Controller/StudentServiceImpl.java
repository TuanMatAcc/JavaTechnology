package com.example.Ex4.Controller;

import com.example.Ex4.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        return (List<Student>)studentRepository.findAll();
    }

    public Student update(Long studentId, Student updatedStudent) {
        if(!studentRepository.existsById(studentId)) {
            return null;
        }
        updatedStudent.setId(studentId);
        return studentRepository.save(updatedStudent);
    }

    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> getStudentAgeGreaterOrEqual(int age) {
        return studentRepository.findStudentsByAgeGreaterThanEqual(age);
    }

    @Override
    public List<Student> getStudentsIeltsScoreEqual(double score) {
        return studentRepository.findStudentsByIeltsScoreEquals(score);
    }

    @Override
    public List<Student> getStudentsNameContainingWord(String subString) {
        return studentRepository.findStudentsByNameContainingIgnoreCase(subString);
    }
}
