package com.petcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/HC")
public class GestionarHistoriaClinica {

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
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/HCbuscar");
		
		return mav;
	}
	
	@RequestMapping("/registrar")
	public ModelAndView registrar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(){
		ModelAndView mav = new ModelAndView("medica/HCdetalle");
		
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
