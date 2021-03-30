package com.anvil.rakoi.anvil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@RequestMapping("/")
	public String hello(ModelMap modelmap) {
		return "index";
	}
	

	
}
