package com.dineshi.studentinfosystem.service;

import com.dineshi.studentinfosystem.model.student;
import com.dineshi.studentinfosystem.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentServiceImplementation implements studentService {
   @Autowired
   private studentRepository StudentRepository;
    @Override
    public student savestudent(student Student) {
        return StudentRepository.save(Student);
    }
}
