package com.pcc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.pcc.ShareVaribles;

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

	@Value("${app.db.poolSize:10}")
	public int dbPoolSize;

	@Value("${app.db.poolName:dbPool1}")
	public String dbPoolName;
	
	@Value("${app.showdesc:Test}")
	public String app_showdesc;
	
	@Value("${app.microservice.url}")
	public String app_microservice_url;
	
	@Value("${app.webservice.url}")
	public String app_webservice_url;

	@PostConstruct
	public void init() {
		//ทำงานตอนเริ่มระบบครั้งแรก
		log.info("Start ...");
		
		log.info("===ShareVaribles===");
		ShareVaribles.app_showdesc = this.app_showdesc;
		ShareVaribles.app_microservice_url = this.app_microservice_url;
		ShareVaribles.app_webservice_url = this.app_webservice_url;
		
		log.info("===Set database for db1===");
		log.info("dbUrl : {}", dbUrl);
		log.info("dbUser : {}", dbUser);
		log.debug("dbPassword : {}", dbPassword);
		log.info("dbPoolSize : {}", dbPoolSize);
		log.info("dbPoolName : {}", dbPoolName);
		com.pcc.sys.lib.FDbc.initializeDataSource(dbUrl, dbUser, dbPassword, dbPoolSize, dbPoolName);
		
	}

}
