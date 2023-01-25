package com.nithish.studentProject.controller;

import com.nithish.studentProject.model.Student;
import com.nithish.studentProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController{

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "new Student is added";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return "successfully deleted";
    }

    @PutMapping("/update/{id}")
    public String updateById(@RequestBody Student student, @PathVariable int id){
        studentService.updateById(student,id);
        return "updated successfully";
    }

}
