package com.example.demo.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service

public class StudentService {


    @Autowired
 private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){

       return studentRepository.findAll();

    }


    public void AddNewStudent(Student student) {


        Optional <Student> StudentOptional =  studentRepository.findStudentByEmail(student.getEmail());

        if (StudentOptional.isPresent()){

            throw new IllegalStateException("eMAIL Already Taken");

        }
        studentRepository.save(student);

    }

    public void DeleStudent(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id "+   studentId   +"Does not exist");
        }
        studentRepository.deleteById(studentId);

    }


    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

     Student student = studentRepository.findById(studentId)
      .orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist"));

            if (name != null &&
                     name.length() > 0 &&
                     !Objects.equals(student.getName(), name)) {
                     student.setName(name);
            }

            if (email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), email)) {
                Optional<Student> studentOptional = studentRepository
                        .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);

            }






    }
}
