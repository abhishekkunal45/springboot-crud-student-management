package com.example.crudSpringBootdemo.Repository;

import com.example.crudSpringBootdemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
