package com.petcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcenter.dto.TipoExamenDTO;
import com.petcenter.service.ActualizarTipoExamenMedicoService;

@Controller
@RequestMapping("/consultarTipoExamen")
public class ConsultarTipoExamenMedicoController {
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizaTipoExamenMedicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model){
		
		return "laboratorio/consultarTipoExamen";
	}
	
	@RequestMapping(value="/buscar",
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody List<TipoExamenDTO> buscarTipoExamen(@RequestParam("nombre") String nombre, 
															  Model model) {
		List<TipoExamenDTO> lista = actualizaTipoExamenMedicoService.buscarTiposExamen(nombre, "", "0", "0");
		return lista;
	}

}
