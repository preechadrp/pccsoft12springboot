package com.pcc.sys.lib;

import java.util.Locale;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import lombok.extern.slf4j.Slf4j;

/**
 * ระบบจะรันตัวเองอัตโนมัติเมื่อ tomcat ทำงาน ไม่ต้องประกาศใน web.xml เพราะใช้
 * Annotation
 *
 */
@Slf4j 
public class MyStartConfigListener implements ServletContextListener {

	
	/**
	 * Default constructor.
	 */
	public MyStartConfigListener() {
		log.info("MyStartConfigListener -- constructor");

		// แก้ปัญหาเรื่อง prepare statment ( setdate ,settimestamp )
		// สำคัญมากถ้าเกี่ยวกับการใช้ JDBC เชื่อมฐานข้อมูล
		// ทดสอบเมื่อ 5/3/63 เมนูบันทึกบัญชี GL(สมุดรายวัน)
		Locale.setDefault(Locale.ENGLISH);
		
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		log.info("MyStartConfigListener -- contextInitialized");
	}
	
	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("MyStartConfigListener -- contextDestroyed");
	}

}
