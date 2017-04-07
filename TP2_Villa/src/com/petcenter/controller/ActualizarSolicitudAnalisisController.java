package com.petcenter.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcenter.dto.DetalleSolicitudExamenClinicoDTO;
import com.petcenter.dto.SolicitudExamenClinicoDTO;
import com.petcenter.dto.TipoExamPrecioExamVigDTO;
import com.petcenter.service.SolicitudExamenService;

@Controller
@RequestMapping("/actualizarSolicitudAnalisis")
public class ActualizarSolicitudAnalisisController {
	
	@Autowired
	private SolicitudExamenService solicitudExamenService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model){
		
		return "medica/actualizarSolicitudAnalisis";
	}
	
	@RequestMapping(value="/consultarSolicitudesExamenes", 
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody List<SolicitudExamenClinicoDTO> consultarSolicitudesExamenes(@RequestParam(value="idSolicitudexamen", required=false) String idSolicitudexamen, 
																			      	  @RequestParam("idCliente") int idCliente, 
																			      	  @RequestParam(value="fechaInicial", required=false) String fechaInicial, 
																			      	  @RequestParam(value="fechaFinal", required=false) String fechaFinal, 
																			      	  Model model) {
		List<SolicitudExamenClinicoDTO> lista = solicitudExamenService.consultarSolicitudesExamenes(idSolicitudexamen, idCliente, fechaInicial, fechaFinal);
		return lista;
	}
	
	@RequestMapping(value="/nuevoSolicitudAnalisis", method = RequestMethod.GET)
	public String nuevoSolicitudAnalisis(Model model){
		
		model.addAttribute("accion", "nuevo");
		
		model.addAttribute("estados", solicitudExamenService.listaEstados2());
		
		return "medica/nuevoEditarSolicitudAnalisis";
	}
	
	@RequestMapping(value="/recuperarAtencionMedica", 
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody SolicitudExamenClinicoDTO recuperarAtencionMedica(@RequestParam("idAM") int idAM, 
																		   Model model) {
		SolicitudExamenClinicoDTO s = solicitudExamenService.recuperarAtencionMedica(idAM);
		return s;
	}
	
	@RequestMapping(value="/registrarSolicitudExamen", 
	consumes = "application/json", 
    produces="application/json; charset=UTF-8", 
    method=RequestMethod.POST)
	public @ResponseBody String registrarSolicitudExamen(@RequestBody SolicitudExamenClinicoDTO sec, 
														 Model model) throws Exception {
		
		String pk = solicitudExamenService.registrarSolicitudExamen(sec);

		return pk;
	}
	
	@RequestMapping(value="/consultarTipoExamPrecioExamVig", 
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody List<TipoExamPrecioExamVigDTO> consultarTipoExamPrecioExamVig(@RequestParam(value="idExamenClinico", required=false) String idExamenClinico, 
																			      	   @RequestParam(value="nombreExamenClinico", required=false) String nombreExamenClinico, 
																			      	   Model model) {
		List<TipoExamPrecioExamVigDTO> lista = solicitudExamenService.consultarTipoExamPrecioExamVig(idExamenClinico, nombreExamenClinico);
		return lista;
	}
	
	@RequestMapping(value="/modificarSolicitudAnalisis", method = RequestMethod.GET)
	public String modificarSolicitudAnalisis(@RequestParam("idSolicitudexamen") String idSolicitudexamen, 
											 Model model){
		
		model.addAttribute("accion", "modificar");
		
		model.addAttribute("estados", solicitudExamenService.listaEstados2());
		
		SolicitudExamenClinicoDTO sec = solicitudExamenService.consultarSolicitudesExamenes(idSolicitudexamen, 0, null, null).get(0);
		
		model.addAttribute("sec", sec);
		
		 List<DetalleSolicitudExamenClinicoDTO> detalle = solicitudExamenService.recuperarDetalle(idSolicitudexamen);
		 
		 model.addAttribute("detalle", detalle);
		
		return "medica/nuevoEditarSolicitudAnalisis";
	}
	
	@RequestMapping(value="/actualizarSolicitudExamen", 
	consumes = "application/json", 
    produces="application/json; charset=UTF-8", 
    method=RequestMethod.POST)
	public @ResponseBody String actualizarSolicitudExamen(@RequestBody SolicitudExamenClinicoDTO sec, 
														  Model model) throws Exception {
		
		solicitudExamenService.actualizarSolicitudExamenClinico(sec);

		return "OK";
	}

}
