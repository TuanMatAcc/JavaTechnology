package com.example.Ex6.Controller;

import com.example.Ex6.Model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query(value = "SELECT s FROM Student s WHERE s.age >= :age")
    public List<Student> findAgeGreaterEqual(@Param("age") int age);
    @Query(value = "SELECT s FROM Student s WHERE s.ieltsScore = :score")
    public List<Student> findIeltsScoreEquals(@Param("score") double score);
    @Query(value="SELECT s FROM Student s WHERE lower(s.name) LIKE LOWER(:name) ")
    public List<Student> findNameContains(@Param("name") String subString);
}
