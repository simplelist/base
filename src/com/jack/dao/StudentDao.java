package com.jack.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jack.entity.Student;


public interface StudentDao extends PagingAndSortingRepository<Student, Long>{

}
