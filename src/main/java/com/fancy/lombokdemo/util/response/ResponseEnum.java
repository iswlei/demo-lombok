package com.fancy.lombokdemo.util.response;

public enum ResponseEnum {
	
	SUCCESS("1", "成功!"),
	NOT_FOUND("404", "资源未找到!"),
	FAILURE("-1", "失败!"),
	BREAKER("-100", "触发熔断"),
	;
	
	private String  code;
	private String message;
	
	private ResponseEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
