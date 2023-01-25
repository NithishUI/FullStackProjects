package com.nithish.studentProject.service;

import com.nithish.studentProject.model.Student;
import com.nithish.studentProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateById(Student student, int id) {
        return studentRepository.findById(id).map(student1 -> {student1.setName(student.getName());
            student1.setAddress(student.getAddress());
            return studentRepository.save(student1);}).
                orElseGet(()->{student.setId(id); return studentRepository.save(student);});

    }


}
