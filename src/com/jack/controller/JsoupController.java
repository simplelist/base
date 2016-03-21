package com.jack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.entity.Student;
import com.jack.service.StudentService;
import com.jack.spider.jsoup.JsoupParseHtml;

@RestController
@RequestMapping("/jsoup")
public class JsoupController {
	@Autowired
	private StudentService	studentService;

	@RequestMapping("/jsoup")
	public void jsoupRun() {
		List<String> contents = JsoupParseHtml.fetchContent(5);
		saveStudent(contents);
	}
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Student> findAll() {
		return studentService.findAll();
	}

	public void saveStudent(List<String> ht_l) {
		List<Student> lists = new ArrayList<Student>();
		for (String string : ht_l) {
			Student student = new Student();
			student.setName(string);
			lists.add(student);
		}
		studentService.saveAll(lists);
	}
}
