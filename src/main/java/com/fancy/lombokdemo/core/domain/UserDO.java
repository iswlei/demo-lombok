package com.fancy.lombokdemo.core.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class UserDO  implements Serializable {
	
	private static final long serialVersionUID = 478791277431958324L;

	private Long id;

    private @Getter String name;

    private Integer age;

}