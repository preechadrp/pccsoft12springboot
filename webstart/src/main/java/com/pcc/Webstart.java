package com.pcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Webstart {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	
	public static void main(String[] args) {
		SpringApplication.run(Webstart.class, args);
	}

}
