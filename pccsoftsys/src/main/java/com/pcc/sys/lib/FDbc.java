package com.pcc.sys.lib;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FDbc extends FDbcMaster {

	private static HikariDataSource dataSource;

	public FDbc() throws Exception {
		try {
			// HikariCP จะจัดการการให้และคืน Connection ให้โดยอัตโนมัติ
			if (dataSource == null) {
				throw new IllegalStateException("DataSource Not Initialized");
			}
			objConn = dataSource.getConnection();
			objConn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		} catch (java.sql.SQLException ex) {
			throw new Exception(ex.getMessage());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	public static void initializeDataSource(String dbUrl, String dbUser,
			String dbPassword, int dbPoolSize, String dbPoolName) {

		log.info("initializeDataSource");

		// 1. สร้าง HikariConfig
		var config = new HikariConfig();

		// 2. ตั้งค่า Connection (สำหรับ Pure JDBC)
		config.setJdbcUrl(dbUrl);
		config.setUsername(dbUser);
		config.setPassword(dbPassword);

		// 3. ตั้งค่า Pool (ค่าแนะนำ)
		config.setMaximumPoolSize(dbPoolSize); // จำนวน Connection สูงสุด
		config.setMinimumIdle(2);              // คงไว้ขั้นต่ำ 2 connection
		config.setIdleTimeout(180000);         // 3 นาที (ms)
		config.setMaxLifetime(1800000);        // 30 นาที (กัน connection เน่า)
		config.setConnectionTimeout(30000);    // timeout ตอนขอ connection
		
		config.setPoolName(dbPoolName);

		// 4. สร้าง HikariDataSource
		dataSource = new HikariDataSource(config);
	}

}
