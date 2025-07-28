package com.pcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pcc.sys.lib.FConstComm;

@SpringBootApplication
public class Webstart {

	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	
	public static void main(String[] args) {
		logger.info("<== Start by main method ==>");
		FConstComm.runAppMode = 1; //มีผลกับการเชื่อมฐานข้อมูล
		SpringApplication.run(Webstart.class, args);
	}

}
