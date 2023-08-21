package com.dineshi.studentinfosystem.service;

import com.dineshi.studentinfosystem.model.student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface studentService {
    public student savestudent(student Student);  //save/Add student details
    public List<student> getAllstudents();  //get all students details from database
    student getStudentById(int id); //get particular student details

//  void updateStudent(int id, student updatedStudent); //update total details of particular student
    void updateStudentAttribute(int id, String attributeName, String newValue);///update specific attribute of a studnet
    void deleteStudentById(int id);  //remove one student from database


}
