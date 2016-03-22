package com.jack.controller;

import java.util.ArrayList;
import java.util.List;

import com.jack.entity.QiuBai;
import com.jack.service.QiuBaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jack.spider.jsoup.QiuBaiParseHtml;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/qiubai")
public class JsoupController {
	@Autowired
	private QiuBaiService qiuBaiService;

	@RequestMapping("/jsoup")
	public List<QiuBai> jsoupRun() {
		List<QiuBai> contents = QiuBaiParseHtml.fetchContent(1);
		qiuBaiService.saveAll(contents);
        return contents;
	}


	@ResponseBody
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public QiuBai findById(@PathVariable Long id){
		return qiuBaiService.get(id);
	}
	@RequestMapping("/qiubai")
	@ResponseBody
	public List<QiuBai> findAll() {
		return qiuBaiService.findAll();
	}


}
