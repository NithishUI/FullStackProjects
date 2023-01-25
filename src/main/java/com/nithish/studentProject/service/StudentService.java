package com.nithish.studentProject.service;

import com.nithish.studentProject.model.Student;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public void deleteById(int id);

    public Student updateById(Student student,int id);
}
