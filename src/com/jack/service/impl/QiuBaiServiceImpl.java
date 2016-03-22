package com.jack.service.impl;

import com.jack.dao.QiuBaiDao;
import com.jack.entity.QiuBai;
import com.jack.service.QiuBaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service()
@Transactional
public class QiuBaiServiceImpl implements QiuBaiService{

	@Autowired
	private QiuBaiDao qiubaiDao;

	@Override
	public QiuBai get(Long id) {
		return qiubaiDao.findOne(id);
	}

	@Override
	public void saveAll(List<QiuBai> list) {
		qiubaiDao.save(list);
	}


	@Override
	public QiuBai save(QiuBai qiuBai) {
		return qiubaiDao.save(qiuBai);
	}

	@Override
	public List<QiuBai> findAll() {
		Iterable<QiuBai> l=qiubaiDao.findAll();
		List<QiuBai> list=new ArrayList<QiuBai>();
		for (Iterator iter = l.iterator(); iter.hasNext();) {
			QiuBai str = (QiuBai)iter.next();
			list.add(str);
		}
		return list;
	}

}
