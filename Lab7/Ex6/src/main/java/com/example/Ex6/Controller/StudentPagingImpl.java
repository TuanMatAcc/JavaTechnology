package com.example.Ex6.Controller;

import com.example.Ex6.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPagingImpl {
    @Autowired
    StudentPagingRepository studentPagingRepository;

    public List<Student> getStudentsSortedByAgeScore() {
        return studentPagingRepository.findAll(Sort.by("age").descending().and(Sort.by("ieltsScore")));
    }

    public void getStudents456() {
        PageRequest pageRequest = PageRequest.of(1, 3);
        studentPagingRepository.findAll(pageRequest).forEach(System.out::println);
    }
}
