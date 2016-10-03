package com.petcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.service.ActualizarTipoExamenMedicoService;
import com.petcenter.util.LaboratorioConstantes;

@Controller
@RequestMapping("/actualizarTipoExamen")
public class ActualizarTipoExamenMedicoController {
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizaTipoExamenMedicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView inicio(){
		
	    ModelAndView modelAndView = new ModelAndView(LaboratorioConstantes.VISTA_ACTUALIZA_TIPO_EXAMEN);
//		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
//		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
//		modelAndView.addObject(LaboratorioConstantes.NOMBRE_LISTA_ESPECIALIDADES, listaEspecialidades);
//		modelAndView.addObject(LaboratorioConstantes.NOMBRE_LISTA_ESTADOS, listaEstados);

		return modelAndView;
	}

}