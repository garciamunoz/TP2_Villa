package com.petcenter.laboratorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/actualizarTipoExamen")
public class ActualizarTipoExamenMedicoController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String inicio(){
		System.out.println("En el metodo");
		return "laboratorio/actualizarTipoExamen";
	}

}
