package com.fancy.lombokdemo.core.service;

import com.fancy.lombokdemo.core.domain.UserDO;

public interface UserService {
	
    UserDO get(Long id);

}