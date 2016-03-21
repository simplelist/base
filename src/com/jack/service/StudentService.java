package com.jack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jack.entity.Student;

@Service
public interface StudentService {
	Student get(Long id);

	void saveAll(List<Student> list);

	Student save(Student student);

	List<Student> findAll();
}
