package com.fancy.lombokdemo.interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fancy.lombokdemo.annotation.SignCheck;
import com.fancy.lombokdemo.util.response.ResponseEnum;
import com.fancy.lombokdemo.util.response.ResponseResult;

/**
 * 
 * @Description: 自定义拦截器
 * @author wlei
 * @date 2017年6月1日 上午10:39:44
 *
 */
public class MyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		return doHandle(request, response, handler);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	private boolean doHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		boolean pass = true;
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			SignCheck signCheck = (SignCheck) method.getMethod().getAnnotation(SignCheck.class);
			if (signCheck != null) {// 判断是否有自定义注解
				String message = "";
				String sign = request.getParameter("sign");
				if (StringUtils.isNotBlank(sign)) {
					pass = true;
				} else {
					pass = false;
					message = "需要提供签名";
				}

				if (pass == false) {// 如果签名正确则继续处理controller;如果签名失败则返回错误提示
//					response.setStatus(HttpStatus.SC_UNAUTHORIZED);
					response.setStatus(HttpStatus.OK.value());
					response.setHeader("Content-type", "application/json;charset=UTF-8");
					response.setContentType("application/json;charset=UTF-8");
					ResponseResult result = ResponseResult.error(ResponseEnum.FAILURE, message);
					response.getWriter().write(JSON.toJSONString(result, SerializerFeature.NotWriteDefaultValue));
				}

			}
		}
		return pass;

	}

}
