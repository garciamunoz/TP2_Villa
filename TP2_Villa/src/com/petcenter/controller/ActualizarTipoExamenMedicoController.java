package com.petcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcenter.dto.EspecialidadDTO;
import com.petcenter.dto.EstadoDTO;
import com.petcenter.dto.TipoExamenDTO;
import com.petcenter.service.ActualizarTipoExamenMedicoService;
import com.petcenter.util.LaboratorioConstantes;

@Controller
@RequestMapping("/actualizarTipoExamen")
public class ActualizarTipoExamenMedicoController {
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizaTipoExamenMedicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model){
		
	 
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESPECIALIDADES, listaEspecialidades);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESTADOS, listaEstados);

		return LaboratorioConstantes.VISTA_ACTUALIZA_TIPO_EXAMEN;
	}
	
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public String buscarTipoExamen(	@RequestParam("nombre") String nombre,
									@RequestParam("descripcion") String descripcion,
									@RequestParam("idEst") Integer idEst,
									@RequestParam("idEsp") Integer idEsp,
									Model model) {
		List<TipoExamenDTO> listaTiposExamenesMedicos = actualizaTipoExamenMedicoService.buscarTiposExamen(nombre, descripcion, idEst, idEsp);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_TIPOS_EXAMENES_MEDICOS, listaTiposExamenesMedicos);
		return inicio(model);
	}
	
	@RequestMapping(value="/nuevoTipoExamen", method=RequestMethod.GET)
	public String cargarNuevoTipoExamen(Model model){
		return LaboratorioConstantes.VISTA_NUEVO_TIPO_EXAMEN;
	}

}
