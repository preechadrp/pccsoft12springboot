package com.pcc.webstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCtrl {

	@GetMapping("/") 
    public String home() {
		return "forward:/login.zul"; 
		//return "redirect:login.zul";	    
    }
	
	@GetMapping("/login")   //สร้างเพื่อให้พิมพ์ http://localhost:8080/login   โดยไม่ต้องใส่ .zul ต่อท้าย
    public String login() {
        return "forward:/login.zul";  
    }
	
	@GetMapping("/menu")  //สร้างเพื่อให้พิมพ์ http://localhost:8080/menu   โดยไม่ต้องใส่ .zul ต่อท้าย
    public String menu() {
        return "forward:/menu.zul";
    }
	
	@GetMapping("/timeout")
    public String timeout() {
        return "forward:/timeout.zul";
    }
	
}
