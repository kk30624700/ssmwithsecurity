package com.boottest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boottest.service.CityService;

@Controller
public class WelcomeController {

    @Autowired
    private CityService cityService;
 
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		System.out.println("/");
		return "index";
	}
	
	@RequestMapping("/city")
	public String city(Map<String, Object> model) {
		System.out.println("/city");
		model.put("city", cityService.getFirst());
		return "city";
	}
	
	@RequestMapping("/excep")
	public String excep(Map<String, Object> model) {
		System.out.println("/exception");
		throw new RuntimeException();
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handlerRuntimeException() {
		return "exception";
	}

}