package com.fancy.lombokdemo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fancy.lombokdemo.interceptor.MyInterceptor;

@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	MyInterceptor myInterceptor() {
		return new MyInterceptor();
	}

	/* 
	 * 设置拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	/* 
	 * json解析器
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);

		/*
		 * 1、先定义一个convert转换消息的对象 2、添加fastjson的配置信息，比如是否要格式化返回的json数据；
		 * 3、在convert中添加配置信息 4、将convert添加到converters
		 */

		// 1、先定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 2、添加fastjson的配置信息，比如是否要格式化返回的json数据；
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				// 是否需要格式化
				SerializerFeature.PrettyFormat);
		// 附加：处理中文乱码（后期添加）
		List<MediaType> fastMedisTypes = new ArrayList<MediaType>();
		fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMedisTypes);
		// 3、在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		// 4、将convert添加到converters
		converters.add(fastConverter);
	}

}
