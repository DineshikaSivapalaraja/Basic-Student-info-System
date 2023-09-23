package com.dineshi.studentinfosystem.controller;

import com.dineshi.studentinfosystem.model.student;
import com.dineshi.studentinfosystem.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/Student")
@CrossOrigin
public class studentController {
    @Autowired
    private studentService StudentService;

    //    Add values to Database
    @PostMapping("/add")   //insert student info to the database
    public String add(@RequestBody student Student){
        StudentService.savestudent(Student);
        return "New student is added";
    }

    //Get values from Database
    @GetMapping("/getAll")  //get all students details from database
    public List<student> getAllstudents(){
        return StudentService.getAllstudents();
    }
    @GetMapping("/get/{id}")  // get particular student details
    public ResponseEntity<student> getStudentById(@PathVariable int id) {
        student studentById = StudentService.getStudentById(id);
        if (studentById != null) {
            return ResponseEntity.ok(studentById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Update Values to Database
//    @PutMapping("/update/{id}") //update any of one specific attribute of student
//    public String updateStudent(@PathVariable int id, @RequestBody Map<String, String> updateData) {
//        String attributeName = updateData.get("attributeName");
//        String newValue = updateData.get("newValue");
//        StudentService.updateStudentAttribute(id, attributeName, newValue);
//        return "Student with ID " + id + " has been updated.";
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Map<String, String> updateData) {
        String attributeName = updateData.get("attributeName");
        String newValue = updateData.get("newValue");

        if (attributeName == null || newValue == null) {
            return ResponseEntity.badRequest().body("Invalid request body.");
        }

        student existingStudent = StudentService.getStudentById(id);

        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            StudentService.updateStudentAttribute(id, attributeName, newValue);
            return ResponseEntity.ok("Student with ID " + id + " has been updated.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //    @PutMapping("/update/{id}")  //update total detail of a particular student
    //    public String updateStudent(@PathVariable int id, @RequestBody student updatedStudent) {
    //   StudentService.updateStudent(id, updatedStudent);
    //  return "Student with ID " + id + " has been updated.";
    //    }

    //Delete values from database
    @DeleteMapping("/delete/{id}")  //remove one student from database
    public String deleteStudent(@PathVariable int id) {
        StudentService.deleteStudentById(id);
        return "Student with ID " + id + " has been deleted.";
    }

//    @DeleteMapping("/delete/{stu_id}")  //remove one student from database
//    public String deleteStudent(@PathVariable String stu_id) {
//        StudentService.deleteStudentById(stu_id);//(stu_id);
//        return "Student with ID " + stu_id + " has been deleted.";
//    }
}
