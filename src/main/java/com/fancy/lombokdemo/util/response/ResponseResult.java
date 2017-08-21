package com.fancy.lombokdemo.util.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ResponseResult<T> {

	private String msg;
	private T data;
	private String code;
	// 列表需要返回数量
	@JSONField(serialzeFeatures = SerializerFeature.NotWriteDefaultValue)
	private long count;

	public static <T> ResponseResult<T> ok() {
		ResponseResult result = new ResponseResult<>();
		result.setCode(ResponseEnum.SUCCESS.getCode());
		result.setMsg(ResponseEnum.SUCCESS.getMessage());
		return result;
	}

	public static <T> ResponseResult<T> ok(T data) {
		ResponseResult result = new ResponseResult<>();
		result.setCode(ResponseEnum.SUCCESS.getCode());
		result.setMsg(ResponseEnum.SUCCESS.getMessage());
		result.setData(data);
		return result;
	}

	public static <T> ResponseResult<T> ok(T data, long count) {
		ResponseResult result = new ResponseResult<>();
		result.setCode(ResponseEnum.SUCCESS.getCode());
		result.setMsg(ResponseEnum.SUCCESS.getMessage());
		result.setData(data);
		result.setCount(count);
		return result;
	}

	public static <T> ResponseResult<T> error() {
		ResponseResult result = new ResponseResult<>();
		result.setCode(ResponseEnum.FAILURE.getCode());
		result.setMsg(ResponseEnum.FAILURE.getMessage());
		return result;
	}


	public static <T> ResponseResult<T> error(T data) {
		ResponseResult result = new ResponseResult<>();
		result.setCode(ResponseEnum.FAILURE.getCode());
		result.setMsg(ResponseEnum.FAILURE.getMessage());
		result.setData(data);
		return result;
	}

	public static <T> ResponseResult<T> error(ResponseEnum responseEnum, T data) {
		ResponseResult result = new ResponseResult<>();
		result.setCode(responseEnum.getCode());
		result.setMsg(responseEnum.getMessage());
		result.setData(data);
		return result;
	}

	public static ResponseResult error(ResponseEnum responseEnum, String msg) {
		ResponseResult result = new ResponseResult<>();
		result.setCode(responseEnum.getCode());
		result.setMsg(msg);
		return result;
	}

	
	public static <T> ResponseResult<T> breaker() {
		ResponseResult result = new ResponseResult<>();
		result.setCode(ResponseEnum.BREAKER.getCode());
		result.setMsg(ResponseEnum.BREAKER.getMessage());
		return result;
	}

	public static <T> ResponseResult<T> breaker(T data) {
		ResponseResult result = new ResponseResult<>();
		result.setCode(ResponseEnum.BREAKER.getCode());
		result.setMsg(ResponseEnum.BREAKER.getMessage());
		result.setData(data);
		return result;
	}
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}
