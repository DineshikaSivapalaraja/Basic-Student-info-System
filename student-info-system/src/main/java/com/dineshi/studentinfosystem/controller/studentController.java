package com.dineshi.studentinfosystem.controller;

import com.dineshi.studentinfosystem.model.student;
import com.dineshi.studentinfosystem.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class studentController {
    @Autowired
    private studentService StudentService;

    @PostMapping("/add")
    public String add(@RequestBody student Student){
        StudentService.savestudent(Student);
        return "New student is added";

    }


}
