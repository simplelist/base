package com.jack.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jack.dao.StudentDao;
import com.jack.entity.Student;
import com.jack.service.StudentService;

@Service()
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student get(Long id) {
		return studentDao.findOne(id);
	}

	@Override
	public void saveAll(List<Student> list) {
		studentDao.save(list);
	}

	@Override
	public Student save(Student student) {
		return studentDao.save(student);
	}

	@Override
	public List<Student> findAll() {
		Iterable<Student> l=studentDao.findAll();
		List<Student> list=new ArrayList<Student>();
		for (Iterator iter = l.iterator(); iter.hasNext();) {
			Student str = (Student)iter.next();
			list.add(str);
		}
		return list;
	}

}
