package com.petcenter.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/HC")
public class AdministrarHistoriaClinica {

	@RequestMapping("/listar")
	public ModelAndView listar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(){
		ModelAndView mav = new ModelAndView("medica/HCregistrar");
		
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView cargarDetalle(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
}
