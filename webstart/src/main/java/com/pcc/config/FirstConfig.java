package com.pcc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration("FirstConfig")
public class FirstConfig {

	@Value("${app.db.url}")
	public String dbUrl;

	@Value("${app.db.user}")
	public String dbUser;

	@Value("${app.db.password}")
	public String dbPassword;

	@Value("${app.db.poolSize}")
	public int dbPoolSize;

	@Value("${app.db.poolName}")
	public String dbPoolName;

	@PostConstruct
	public void init() {
		//ทำงานตอนเริ่มระบบครั้งแรก
		log.info("Start ...");
		
		log.info("Set database for db1");
		log.info("dbUrl : {}", dbUrl);
		log.info("dbUser : {}", dbUser);
		log.info("dbPassword : {}", dbPassword);
		log.info("dbPoolSize : {}", dbPoolSize);
		log.info("dbPoolName : {}", dbPoolName);
		com.pcc.sys.lib.db.Db1.initializeDataSource(dbUrl, dbUser, dbPassword, dbPoolSize, dbPoolName);
		
	}

}
