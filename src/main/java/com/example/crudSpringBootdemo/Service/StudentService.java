package com.example.crudSpringBootdemo.Service;

import com.example.crudSpringBootdemo.Entity.Student;
import com.example.crudSpringBootdemo.Repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentreq) {
        //2. Business Logic
        System.out.println("Inside Student Servcice");
        Student studentResp = studentRepository.save(studentreq);
        return studentResp;
    }

    public Student getStudent(Long id) {
        //2. Business Logic
        Optional<Student> studentresp = studentRepository.findById(id);
        //It can return a student or a null if not present
        if (studentresp.isPresent()) {
            return studentresp.get();
        } else {
            return null;
        }
    }

    public List<Student> getAllStudent() {
        List<Student> studentlist = studentRepository.findAll();
        return studentlist;
    }

    public Student updateStudent(Long id, Student studentreq) {
        //2. Business Logic
        Optional<Student> existingstudent = studentRepository.findById(id);
        //It can return a student or a null if not present
        if (existingstudent.isEmpty()) {
            return null;
        }
        Student StudentToSave = existingstudent.get();

        StudentToSave.setAge(studentreq.getAge());
        StudentToSave.setEmail(studentreq.getEmail());
        StudentToSave.setRollno(studentreq.getRollno());
        StudentToSave.setName(studentreq.getName());
        StudentToSave.setSubject(studentreq.getSubject());

        return studentRepository.save(StudentToSave);

    }

    public Boolean deleteStudent(Long id) {
        boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }


}






    //1. End Point Listen (/app/students/POST)

    //2. Business Logic

    //3. Interact with DB

    //4. Response back to client (Postman)

