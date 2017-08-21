package com.fancy.lombokdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @Description: 控制层Rest基类
 * @author wlei
 * @date 2017年6月1日 下午3:28:11
 *
 */
@RestController
public class BaseController {

	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 注册绑定转换器
	 * 
	 * @param binder
	 * @param request
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// 绑定日期转换器
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
}
