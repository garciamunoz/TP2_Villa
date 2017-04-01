package com.petcenter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.dto.Diagnostico;
import com.petcenter.service.DiagnosticoService;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Controller
@RequestMapping("/DIAG")
public class GestionarDiagnosticoController {

	private static final Log log = LogFactory.getLog(GestionarDiagnosticoController.class);
	
//	@Autowired
//	private CommonService commonService;
//	
//	@Autowired
//	private HistoriaClinicaService historiaClinicaService;
//
//	@Autowired
//	private AtencionMedicaService atencionMedicaService;
	
	@Autowired
	private DiagnosticoService diagnosticoService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/DIAGlistar");
//		request.getSession().setAttribute("codigoMedico", 1);
//		request.getSession().setAttribute("datosMedico", "Doc. Vet Corbalan");
//		request.getSession().setAttribute("listaTipoDoc", commonService.listaTipoDoc());
//		request.getSession().setAttribute("listaExamenes", atencionMedicaService.listaExamenes());
//		request.getSession().setAttribute("listaDiagnostico", atencionMedicaService.listaDiagnostico());
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/DIAGregistrar");
		try {
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/DIAGlistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/DIAGbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/DIAGlistar");
		try {

			String txtDESC = request.getParameter("txtDESC");
			String observacion = request.getParameter("txtOBS");
			
			Diagnostico diagnostico = new Diagnostico();
			diagnostico.setDescripcion(txtDESC);
			diagnostico.setObservacion(observacion);
			
			diagnosticoService.registrarDiagnostico(diagnostico);
			
			List<Diagnostico> listaDIAG = diagnosticoService.listaDiagnostico(String.valueOf(diagnostico.getIdDIAG()), "");
			
			request.getSession().setAttribute("listaDIAG", listaDIAG);
			request.getSession().setAttribute("txtDIAG", String.valueOf(diagnostico.getIdDIAG()));
			request.getSession().setAttribute("txtDESC", null);
			
			mav.addObject("mensaje", "Se registró el Diagnóstico con código: "+diagnostico.getIdDIAG());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/DIAGregistrar");
		}
		return mav;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public ModelAndView actualizar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/DIAGlistar");
		try {

			String idDIAD = request.getParameter("hdnDIAG");
			String observacion = request.getParameter("txtOBS");
			
			int resultado = diagnosticoService.actualizarDiagnostico(Integer.parseInt(idDIAD), observacion);
			if(resultado > 0){
				List<Diagnostico> listaDIAG = diagnosticoService.listaDiagnostico(idDIAD, "");
				
				request.getSession().setAttribute("listaDIAG", listaDIAG);
				request.getSession().setAttribute("txtDIAG", idDIAD);
				request.getSession().setAttribute("txtDESC", null);
				
				mav.addObject("mensaje", "Se actualizó el Diagnóstico con código: "+idDIAD);
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/DIAGregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/DIAGlistar");
		try {
			String txtDIAG = request.getParameter("txtDIAG");
			String txtDESC = request.getParameter("txtDESC");
			
			List<Diagnostico> listaDIAG = diagnosticoService.listaDiagnostico(txtDIAG, txtDESC);
			
			request.getSession().setAttribute("listaDIAG", listaDIAG);
			request.getSession().setAttribute("txtDIAG", txtDIAG);
			request.getSession().setAttribute("txtDESC", txtDESC);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idDIAG){
		ModelAndView mav = new ModelAndView("medica/DIAGdetalle");
		try {
			Diagnostico DIAG = diagnosticoService.verDiagnostico(idDIAG);
			mav.addObject("diag", DIAG);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/DIAGlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/DIAGlistar");
		request.getSession().setAttribute("listaDIAG", null);
		request.getSession().setAttribute("txtDIAG", null);
		request.getSession().setAttribute("txtNUMDOC", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idDIAG){
		ModelAndView mav = new ModelAndView("medica/DIAGlistar");
		try {
			int resultado = diagnosticoService.eliminarDiagnostico(idDIAG);
			if(resultado>0){
				mav.addObject("mensaje", "Se eliminó correctamente la Diagnóstico con codigo: "+idDIAG);

				String txtDIAG = (String) request.getSession().getAttribute("txtDIAG");
				String txtDESC = (String) request.getSession().getAttribute("txtDESC");
				
				List<Diagnostico> listaDIAG = diagnosticoService.listaDiagnostico(txtDIAG, txtDESC);
				
				request.getSession().setAttribute("listaDIAG", listaDIAG);
				
			}else{
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
		} catch (Exception e) {
			log.error(e);
		}
		return mav;
	}
	
}
