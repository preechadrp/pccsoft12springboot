package com.pcc.webstart;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ServletInitializer.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("<== Start by ServletInitializer ==>");
		return application.sources(Main.class);
	}

}
