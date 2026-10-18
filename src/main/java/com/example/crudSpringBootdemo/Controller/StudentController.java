package com.example.crudSpringBootdemo.Controller;

import com.example.crudSpringBootdemo.Entity.Student;
import com.example.crudSpringBootdemo.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> CreateStudent(@RequestBody Student student){
        System.out.println("Inside Student Controller");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("Exiting Student Controller");
        return ResponseEntity.status(201).body(createdStudent);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> GetStudent(@PathVariable Long id){
        Student resp= studentService.getStudent(id);
        if(resp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(resp);
        //return ResponseEntity.ok(resp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> GetAllStudent(){
        List<Student> studentsList = studentService.getAllStudent();
        if(studentsList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentsList);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> UpdateStudent(@PathVariable Long id, @RequestBody Student studentreq){
        Student resp= studentService.updateStudent(id, studentreq);
        if(resp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(resp);
        //return ResponseEntity.ok(resp);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record deleted");
    }

}