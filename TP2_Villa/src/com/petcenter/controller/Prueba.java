package com.petcenter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/prueba")
public class Prueba {

	@RequestMapping("/")
	public String inicio(){
		return "medica/prueba";
	}
	
	@RequestMapping(value="/ajax", method=RequestMethod.POST)
	public @ResponseBody String  agregarItem (HttpServletRequest request,
								@RequestParam("txtFILE") MultipartFile txtFILE){

		System.out.println(txtFILE);
		
		return txtFILE.getOriginalFilename();
	}
	
}
