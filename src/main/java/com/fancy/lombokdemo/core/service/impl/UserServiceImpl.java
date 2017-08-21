package com.fancy.lombokdemo.core.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fancy.lombokdemo.core.domain.UserDO;
import com.fancy.lombokdemo.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDO get(Long id) {
		return UserDO.builder().id(1L)
								.name("王磊")
								.age(18)
								.build();
	}
}
