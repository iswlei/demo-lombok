package com.fancy.lombokdemo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fancy.lombokdemo.annotation.SignCheck;
import com.fancy.lombokdemo.core.domain.UserDO;
import com.fancy.lombokdemo.core.service.UserService;
import com.fancy.lombokdemo.util.response.ResponseEnum;
import com.fancy.lombokdemo.util.response.ResponseResult;

@RestController
@RequestMapping("${api.prefix}/user")
public class UserController extends BaseController {

	@Resource
	private UserService userService;

	@RequestMapping("get")
	public ResponseResult get(Long id) {

		UserDO userDO = userService.get(id);

		if (userDO != null) {
			return ResponseResult.ok(userDO);
		}
		return ResponseResult.error(ResponseEnum.FAILURE, "不存在记录");
	}

	
}
