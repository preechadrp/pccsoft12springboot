package com.pcc.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;
import org.zkoss.zk.ui.http.HttpSessionListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by preecha on 5/12/67
 */
@Configuration
class ZKConfiguration {

	@Bean
	ServletRegistrationBean dHtmlLayoutServlet() {
		// zk config
		ServletRegistrationBean reg = new ServletRegistrationBean(new DHtmlLayoutServlet(), "*.zul");
		reg.setLoadOnStartup(10);
		
		Map<String, String> params = new HashMap<>();
		params.put("update-uri", "/zkau");
		reg.setInitParameters(params);
		
		return reg;
	}

	@Bean
	ServletRegistrationBean dHtmlUpdateServlet() {
		// zk config
		ServletRegistrationBean reg = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*");
		reg.setLoadOnStartup(11);
		
		Map<String, String> params = new HashMap<>();
		params.put("update-uri", "/zkau/*");
		reg.setInitParameters(params);
		
		return reg;
	}

	@Bean
	HttpSessionListener httpSessionListener() {
		return new HttpSessionListener();
	}

	@Bean
	ViewResolver viewResolver() {
		// zk config
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//viewResolver.setPrefix("/WEB-INF/zul/");
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".zul");
		//viewResolver.setOrder(2); ลำดับยิ่งมากยิ่งอยู่หลังสุด
		return viewResolver;
	}

}