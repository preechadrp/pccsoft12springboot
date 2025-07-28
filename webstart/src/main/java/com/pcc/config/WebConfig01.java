package com.pcc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.pcc.api.core.AppApiServlet;
import com.pcc.api.core.Authen;
import com.pcc.api.core.JwtAuthFilter;
import com.pcc.sys.lib.MyStartConfigListener;

/**
 * Created by preecha on 5/12/67
 */
@Configuration
public class WebConfig01 {

//	@Override  //เมื่อใช้งาน @EnableWebMvc และ WebConfig01 implements WebMvcConfigurer  จะต้องจัดการ resource เพิ่มเพราะระบบจะไม่เห็น  path เหล่านี้
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//      registry.addResourceHandler("/resources/**") .addResourceLocations("classpath:/static/");
//	    registry.addResourceHandler("/*.css").addResourceLocations("/");
//	    registry.addResourceHandler("/font/**").addResourceLocations("font/");
//	    registry.addResourceHandler("/img/**").addResourceLocations("img/");
//	    registry.addResourceHandler("/javascripts/**").addResourceLocations("javascripts/");
//	}
//	
//	@Override //เมื่อใช้งาน @EnableWebMvc และ WebConfig01 implements WebMvcConfigurer
//	public void addViewControllers(ViewControllerRegistry registry) {
//		System.out.println("set home page to redirect:/login");
//	    registry.addViewController("/").setViewName("redirect:/login"); //ok
//	    //registry.addViewController("/").setViewName("login"); //ok
//	}

	@Bean("MyStartConfigListener")
	@Order(Ordered.HIGHEST_PRECEDENCE)
	MyStartConfigListener myStartConfigListener() {
		// การนำ ServletContextListener แบบเดิมมาใช้งาน
		return new MyStartConfigListener();
	}

	@Bean("Authen")
	ServletRegistrationBean authen() {
		// การนำ servlet ที่มีอยู่มาใช้งาน สามารถใช้หลักการ MyRCtl.test3
		// เพื่อดึงข้อมูลและส่งค่ากลับแทนได้
		ServletRegistrationBean reg = new ServletRegistrationBean(new Authen(), "/auth/login");
		reg.setName("Authen");
		return reg;
	}

	@Bean("AppApiServlet")
	ServletRegistrationBean appapi() {
		// การนำ servlet ที่มีอยู่มาใช้งาน สามารถใช้หลักการ MyRCtl.test3
		// เพื่อดึงข้อมูลและส่งค่ากลับแทนได้
		ServletRegistrationBean reg = new ServletRegistrationBean(new AppApiServlet(), "/appapi/*");
		reg.setName("AppApiServlet");
		// reg.setLoadOnStartup(1);
		return reg;
	}

	@Bean("JwtAuthFilter")
	FilterRegistrationBean jwtAuthFilter() {
		// นำ Filter แบบเดิมมาใช้งาน
		FilterRegistrationBean reg = new FilterRegistrationBean();
		reg.setFilter(new JwtAuthFilter());
		reg.addUrlPatterns("/appapi/*");
		// reg.addInitParameter("paramName", "paramValue");
		reg.setName("filter001webservice");
		// reg.setOrder(1);
		return reg;
	}

}
