package com.pcc.sys.lib.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
public class Db1 {

	private static HikariDataSource dataSource;

	public static void initializeDataSource(String dbUrl,String dbUser,
			String dbPassword,int dbPoolSize,String dbPoolName) {
		
		log.info("initializeDataSource");
		
		// 1. สร้าง HikariConfig
		var config = new HikariConfig();

		// 2. ตั้งค่า Connection (สำหรับ Pure JDBC)
		config.setJdbcUrl(dbUrl);
		config.setUsername(dbUser);
		config.setPassword(dbPassword);

		// 3. ตั้งค่า Pool (ค่าแนะนำ)
		config.setMaximumPoolSize(dbPoolSize); // จำนวน Connection สูงสุด
		config.setPoolName(dbPoolName);

		// 4. สร้าง HikariDataSource
		dataSource = new HikariDataSource(config);
	}

	// เมธอดสำหรับดึง Connection 
	public static Connection getConnection() throws SQLException {
		// HikariCP จะจัดการการให้และคืน Connection ให้โดยอัตโนมัติ
		if (dataSource == null) {
			throw new IllegalStateException("DataSource Not Initialized");
		}
		return dataSource.getConnection();
	}

}
