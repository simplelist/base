package com.jack.service;

import com.jack.entity.QiuBai;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QiuBaiService {
	QiuBai get(Long id);

	void saveAll(List<QiuBai> list);

	QiuBai save(QiuBai student);

	List<QiuBai> findAll();

}
