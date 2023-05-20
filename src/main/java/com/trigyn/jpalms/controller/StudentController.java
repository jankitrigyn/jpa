package com.trigyn.jpalms.controller;

import com.trigyn.jpalms.model.BookVO;
import com.trigyn.jpalms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<BookVO> getAllStudentDetails(@RequestParam(required = false) String name){
        if(name!=null){
            return studentService.findStudentByUserName(name);
        }else {
            return studentService.getAllStudentDetails();
        }
    }

    @PostMapping("/student")
    public Boolean saveStudent(@RequestBody BookVO bookVO){
        return studentService.saveStudent(bookVO);
    }
}
