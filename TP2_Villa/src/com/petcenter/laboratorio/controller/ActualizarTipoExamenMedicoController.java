package com.petcenter.laboratorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.laboratorio.dto.EspecialidadDTO;
import com.petcenter.laboratorio.dto.EstadoDTO;
import com.petcenter.laboratorio.service.ActualizarTipoExamenMedicoService;
import com.petcenter.laboratorio.util.LaboratorioConstantes;

@Controller
@RequestMapping("/actualizarTipoExamen")
public class ActualizarTipoExamenMedicoController {
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizaTipoExamenMedicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView inicio(){
		
	    ModelAndView modelAndView = new ModelAndView(LaboratorioConstantes.VISTA_ACTUALIZA_TIPO_EXAMEN);
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
		modelAndView.addObject("listaEspecialidades", listaEspecialidades);
		modelAndView.addObject("listaEstados", listaEstados);

		return modelAndView;
	}

}
