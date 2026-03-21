package com.pcc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
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
@DependsOn("FirstConfig")
public class WebConfig01 {

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
