package com.pcc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.pcc.sys.lib.FConstComm;

public class ServletInitializer extends SpringBootServletInitializer {
	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("<== Start by ServletInitializer ==>");
		FConstComm.runAppMode = 2; //มีผลกับการเชื่อมฐานข้อมูล
		return application.sources(Webstart.class);
	}

}
