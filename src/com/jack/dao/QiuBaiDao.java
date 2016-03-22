package com.jack.dao;

import com.jack.entity.QiuBai;
import com.jack.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface QiuBaiDao extends PagingAndSortingRepository<QiuBai, Long>{

}
