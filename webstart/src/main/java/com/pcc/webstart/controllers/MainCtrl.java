package com.pcc.webstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtrl {

	@GetMapping("")  //ใช้  registry.addViewController("/").setViewName("login.zul");  แทนได้
    public String home() {
		return "forward:/login.zul"; 
		//return "redirect:login.zul";
		//return "forward:/login"; จากการทดสอบถ้ารันใน docker ไม่ผ่าน (กรณีระบุ http://localhost:8877/)
	    
    }
	
	@GetMapping("/login")   //สร้างเพื่อให้พิมพ์ http://localhost:8080/login   โดยไม่ต้องใส่ .zul ต่อท้าย
    public String login() {
        return "login"; //ไม่ต้องใส่  .zul ต่อท้าย
    }
	
	@GetMapping("/menu")  //สร้างเพื่อให้พิมพ์ http://localhost:8080/menu   โดยไม่ต้องใส่ .zul ต่อท้าย
    public String menu() {
        return "menu"; //ไม่ต้องใส่  .zul ต่อท้าย
    }
	
	@GetMapping("/timeout")
    public String timeout() {
        return "timeout"; //ไม่ต้องใส่  .zul ต่อท้าย
    }
	
}
