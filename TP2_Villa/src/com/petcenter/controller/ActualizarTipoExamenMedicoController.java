package com.petcenter.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcenter.dto.AtributoDTO;
import com.petcenter.dto.EspecialidadDTO;
import com.petcenter.dto.EstadoDTO;
import com.petcenter.dto.EstandarDTO;
import com.petcenter.dto.NormativaDTO;
import com.petcenter.dto.PrecioDTO;
import com.petcenter.dto.PrecioExamenDTO;
import com.petcenter.dto.TipoExamenDTO;
import com.petcenter.service.ActualizarTipoExamenMedicoService;
import com.petcenter.service.CommonService;
import com.petcenter.service.PrecioExamenService;
import com.petcenter.util.LaboratorioConstantes;


@Controller
@RequestMapping("/actualizarTipoExamen")
public class ActualizarTipoExamenMedicoController {
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizaTipoExamenMedicoService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private PrecioExamenService precioExamenService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model){
		
	 
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESPECIALIDADES, listaEspecialidades);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESTADOS, listaEstados);

		return LaboratorioConstantes.VISTA_ACTUALIZA_TIPO_EXAMEN;
	}
	

	@RequestMapping(value="/buscar",
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody Map<String,Object>  buscarTipoExamen(	@RequestParam("nombre") String nombre,
									@RequestParam("descripcion") String descripcion,
									@RequestParam("idEst") String idEst,
									@RequestParam("idEsp") String idEsp,
									Model model) {
		Map<String,Object> lista = new HashMap<String,Object>();
		List<TipoExamenDTO> listaTiposExamenesMedicos = actualizaTipoExamenMedicoService.buscarTiposExamen(nombre, descripcion, idEst, idEsp);
		lista.put(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_TIPOS_EXAMENES_MEDICOS, listaTiposExamenesMedicos);
		return lista;
	}
	
	@RequestMapping(value="/nuevoTipoExamen", method=RequestMethod.GET)
	public String cargarNuevoTipoExamen(Model model){
		
		model.addAttribute("accion", "registrar");
		
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<NormativaDTO> listaNormativas = actualizaTipoExamenMedicoService.listarNormativa();
		List<EstandarDTO> listaEstandares = actualizaTipoExamenMedicoService.listaEstandares();
		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
		List<PrecioDTO> listaPrecios = actualizaTipoExamenMedicoService.listaPrecios();
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESPECIALIDADES, listaEspecialidades);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_NORMATIVAS, listaNormativas);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_ESTANDARES,listaEstandares);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESTADOS, listaEstados);
		//model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_PRECIOS, listaPrecios);
		
		return LaboratorioConstantes.VISTA_NUEVO_TIPO_EXAMEN;
	}
	
	@RequestMapping(value="/editarTipoExamen", method=RequestMethod.GET)
	public String editarTipoExamen(@RequestParam String idExamenClinico, Model model){
		
		model.addAttribute("accion", "actualizar");
		
		List<EspecialidadDTO> listaEspecialidades = actualizaTipoExamenMedicoService.listarEspecialidades();
		List<NormativaDTO> listaNormativas = actualizaTipoExamenMedicoService.listarNormativa();
		List<EstandarDTO> listaEstandares = actualizaTipoExamenMedicoService.listaEstandares();
		List<EstadoDTO> listaEstados =  actualizaTipoExamenMedicoService.listarEstados();
		List<PrecioExamenDTO> listaPrecios = precioExamenService.listarPreciosExamen(idExamenClinico);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESPECIALIDADES, listaEspecialidades);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_NORMATIVAS, listaNormativas);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_ESTANDARES,listaEstandares);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_ESTADOS, listaEstados);
		model.addAttribute(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_PRECIOS, listaPrecios);
		
		TipoExamenDTO te = actualizaTipoExamenMedicoService.recuperarTipoExamen(idExamenClinico);
		
		model.addAttribute("tipoExamen", te);
		
		return LaboratorioConstantes.VISTA_NUEVO_TIPO_EXAMEN;
	}
	
	/*@RequestMapping(value="/buscarPrecios",
		    produces="application/json; charset=UTF-8",
		    method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> buscarPrecios(@RequestParam("mon") String mon,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate,Model model)throws Exception{
		Map<String,Object> lista = new HashMap<String,Object>();
		List<PrecioDTO> listaPrecios = actualizaTipoExamenMedicoService.listarPrecios(mon,startDate,endDate);
		lista.put(LaboratorioConstantes.NOMBRE_LISTA_BUSQUEDA_PRECIOS, listaPrecios);
		return lista;
	}*/
	
	@RequestMapping(value="/listaTodosAtributos", produces="application/json; charset=UTF-8", method=RequestMethod.GET)
	public @ResponseBody List<AtributoDTO> listaTodosAtributos() throws Exception{
		List<AtributoDTO> l = commonService.listaTodosAtributos();
		return l;
	}
	
	@RequestMapping(value="/registrar", method=RequestMethod.POST, consumes = "application/json", produces="application/json")
	public @ResponseBody String registrar(@RequestBody TipoExamenDTO tipoExamen) throws Exception{
		
		actualizaTipoExamenMedicoService.registrar(tipoExamen);
		
		return "OK";
	}
	
	@RequestMapping(value="/recuperarTipoExamen", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody TipoExamenDTO recuperarTipoExamen(@RequestParam String idExamenClinico) throws Exception{
		
		return actualizaTipoExamenMedicoService.recuperarTipoExamen(idExamenClinico);
	}
	
	@RequestMapping(value="/actualizar", method=RequestMethod.POST, consumes = "application/json", produces="application/json")
	public @ResponseBody String actualizar(@RequestBody TipoExamenDTO tipoExamen) throws Exception{
		
		actualizaTipoExamenMedicoService.actualizar(tipoExamen);
		
		return "OK";
	}

}
