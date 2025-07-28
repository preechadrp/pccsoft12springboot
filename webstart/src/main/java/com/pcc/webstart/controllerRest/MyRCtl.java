package com.pcc.webstart.controllerRest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class MyRCtl {

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello, ZK with Spring Boot and REST API!";
	}

	@PostMapping("/test1")
	public boolean test1(@RequestParam String username, @RequestBody String data) {
		// code and stuff
		return true;
	}

	@GetMapping(value = "/test2/{id}")
	public String test2(@PathVariable("id") String id) {
		return "id = " + id;
	}

	@PostMapping(path = "/test3", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String test3(@RequestBody String data, HttpServletRequest request) {
		
		//การดึง HttpServletRequest มาใช้งาน  โดย data ต้องเป็น string แบบ json
		//ซึ่งเราสามารถเอาไปใช้แทน AppApiServlet ได้เลย
		
		System.out.println("data " + data);
		String data2 = "{\"callmethod\":\"" + request.getMethod() + "\"}";
		return data2;
		
	}

}
