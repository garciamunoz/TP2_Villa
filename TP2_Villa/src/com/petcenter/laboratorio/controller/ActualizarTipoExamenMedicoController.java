package com.petcenter.laboratorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petcenter.laboratorio.dto.EspecialidadDTO;
import com.petcenter.laboratorio.dto.EstadoDTO;
import com.petcenter.laboratorio.service.ActualizarTipoExamenMedicoService;

@Controller
@RequestMapping("/actualizarTipoExamen")
public class ActualizarTipoExamenMedicoController {
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizaTipoExamenMedicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(){
		
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
		return "laboratorio/actualizarTipoExamen";
	}

}
