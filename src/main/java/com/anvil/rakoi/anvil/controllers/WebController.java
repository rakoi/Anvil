package com.anvil.rakoi.anvil.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class WebController {

	@Autowired
	public ServletContext servletContext;



	/*@RequestMapping("/")
	@ResponseBody
	public String hello(ModelMap modelmap) {
		return "index";
	}*/
	@RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
	public void getImageAsByteArray(@PathVariable("id") String imageName,HttpServletResponse response) throws IOException {
		System.out.println(imageName);
		System.out.println("request is");
		String path="/WEB-INF/resources/labels/"+imageName;
		InputStream in = servletContext.getResourceAsStream(path);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		IOUtils.copy(in, response.getOutputStream());
	}


	
}
