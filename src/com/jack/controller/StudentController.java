package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.entity.Student;
import com.jack.service.StudentService;

@RestController
@RequestMapping("/student")  
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@ResponseBody
	@RequestMapping("/find/{id}")  
    public Student find(@PathVariable("id") Long id) {
		Student student=studentService.get(id);
        return student;  
    }
}
