package com.example.demo.services;

import com.example.demo.model.Dormitory;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public Student getStudentById(@PathVariable("id") long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }
    @Transactional
    public Student saveStudent(Student student) {
        var _student = Optional.of(studentRepository.save(student));
        return _student.orElse(new Student());
    }
    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}
