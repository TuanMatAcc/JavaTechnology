package com.example.Ex6.Controller;

import com.example.Ex6.Model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentPagingRepository extends PagingAndSortingRepository<Student, Long> {
    public List<Student> findAll(Sort sort);
}
