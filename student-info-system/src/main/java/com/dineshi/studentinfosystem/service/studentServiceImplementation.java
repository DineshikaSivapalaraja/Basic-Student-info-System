package com.dineshi.studentinfosystem.service;

import com.dineshi.studentinfosystem.model.student;
import com.dineshi.studentinfosystem.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class studentServiceImplementation implements studentService {
   @Autowired
   private studentRepository StudentRepository;
   //Add values to the database
    @Override
    public student savestudent(student Student) {
        return StudentRepository.save(Student);
    }
    //Get values from the database
    @Override   // get all student details
    public List<student> getAllstudents() {
        return StudentRepository.findAll();
    }
    @Override    // get particular student details
    public student getStudentById(int id) {
        return StudentRepository.findById(id).orElse(null);
    }

    //Update to the Database
    //Method 01-----------------//update any of one specific attribute of student
    @Override  //update any of one specific attribute of student
    public void updateStudentAttribute(int id, String attributeName, String newValue) {
        student existingStudent = StudentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));

        switch (attributeName) {
            case "name":
                existingStudent.setName(newValue);
                break;
            case "degree":
                existingStudent.setDegree(newValue);
                break;
            case "stu_id":
                existingStudent.setStu_id(newValue);
                break;
            case "year":
                existingStudent.setYear(Integer.parseInt(newValue));
                break;
            default:
                throw new IllegalArgumentException("Invalid attribute name: " + attributeName);
        }
        StudentRepository.save(existingStudent);
    }

    //Method 02-----------------//update total details of a particular student

    // @Override  //update total details of a particular student
//     public void updateStudent(int id, student updatedStudent) {
//        student existingStudent = StudentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
//
//        existingStudent.setName(updatedStudent.getName());
//        existingStudent.setDegree(updatedStudent.getDegree());
//        existingStudent.setStu_id(updatedStudent.getStu_id());
//        existingStudent.setYear(updatedStudent.getYear());
//
//        StudentRepository.save(existingStudent);
//    }

    //Delete from the database/table
    @Override   //remove one student from database
    public void deleteStudentById(int id) {
        StudentRepository.deleteById(id);
    }

//    @Override   //remove one student from database
//    public void deleteStudentById(String stu_id) {
//        StudentRepository.deleteById(Integer.valueOf(stu_id));
//    }
}
