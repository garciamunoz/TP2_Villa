package com.petcenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.dto.AtencionMedica;
import com.petcenter.dto.Procedimiento;
import com.petcenter.service.AtencionMedicaService;
import com.petcenter.service.ProcedimientoService;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Controller
@RequestMapping("/PM")
public class GestionarProcedimientoController {

	private static final Log log = LogFactory.getLog(GestionarProcedimientoController.class);
	
	@Autowired
	private ProcedimientoService procedimientoService;
	
	@Autowired
	private AtencionMedicaService atencionMedicaService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/PMlistar");
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/PMregistrar");
		try {
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/PMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/PMbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/PMlistar");
		try {

			String txtAM = request.getParameter("txtAM");
			String txtTP = request.getParameter("txtTP");
			String txtDESC = request.getParameter("txtDESC");
			String txtOBS = request.getParameter("txtOBS");
			
			Procedimiento Procedimiento = new Procedimiento();
			Procedimiento.setIdAM(Integer.parseInt(txtAM));
			Procedimiento.setTipoProcedimiento(txtTP);
			Procedimiento.setDescripcion(txtDESC);
			Procedimiento.setObservacion(txtOBS);
			
			procedimientoService.registrarProcedimiento(Procedimiento);
			
			if(Procedimiento.getIdProcedimiento() < 1){
				mav.addObject("mensaje", "Ocurrrió un error al registrar la Procedimiento Médico.");
				mav.setViewName("medica/PMregistrar");
				return mav;
			}
			
			List<Procedimiento> listaPM = procedimientoService.listaProcedimiento("", String.valueOf(Procedimiento.getIdAM()));
			
			request.getSession().setAttribute("listaPM", listaPM); 
			request.getSession().setAttribute("txtPM", null);
			request.getSession().setAttribute("txtAM", String.valueOf(Procedimiento.getIdAM()));
			
			mav.addObject("mensaje", "Se registró el Procedimiento Médico con código: "+Procedimiento.getIdProcedimiento());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/PMregistrar");
		}
		return mav;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public ModelAndView actualizar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/PMlistar");
		try {

			String idPM = request.getParameter("hdnPM");
			String txtTP = request.getParameter("txtTP");
			String txtDESC = request.getParameter("txtDESC");
			String txtOBS = request.getParameter("txtOBS");
			
			int resultado = procedimientoService.actualizarProcedimiento(Integer.parseInt(idPM), txtTP, txtDESC, txtOBS);
			
			if(resultado > 0){
				List<Procedimiento> listaPM = procedimientoService.listaProcedimiento(idPM, "");
				
				request.getSession().setAttribute("listaPM", listaPM);
				request.getSession().setAttribute("txtPM", idPM);
				request.getSession().setAttribute("txtAM", null);
				
				mav.addObject("mensaje", "Se actualizó el Procedimiento Médico con código: "+idPM);
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/PMregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/PMlistar");
		try {
			String txtPM = request.getParameter("txtPM");
			String txtAM = request.getParameter("txtAM");
			
			List<Procedimiento> listaPM = procedimientoService.listaProcedimiento(txtPM, txtAM);
			
			request.getSession().setAttribute("listaPM", listaPM);
			request.getSession().setAttribute("txtPM", txtPM);
			request.getSession().setAttribute("txtAM", txtAM);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idPM){
		ModelAndView mav = new ModelAndView("medica/PMdetalle");
		try {
			Procedimiento PM = procedimientoService.verProcedimiento(idPM);
			mav.addObject("PM", PM);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/PMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/PMlistar");
		request.getSession().setAttribute("listaPM", null);
		request.getSession().setAttribute("txtPM", null);
		request.getSession().setAttribute("txtAM", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idPM){
		ModelAndView mav = new ModelAndView("medica/PMlistar");
		try {
			int resultado = procedimientoService.eliminarProcedimiento(idPM);
			if(resultado>0){
					mav.addObject("mensaje", "Se eliminó correctamente el Procedimiento Médico con código: "+idPM);
			}else{
				log.error("No se elimino el Procedimiento Médico.");
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
			
			String txtPM = (String) request.getSession().getAttribute("txtPM");
			String txtAM = (String) request.getSession().getAttribute("txtAM");
			
			List<Procedimiento> listaPM = procedimientoService.listaProcedimiento(txtPM, txtAM);
			
			request.getSession().setAttribute("listaPM", listaPM);
			
		} catch (Exception e) {
			log.error(e);
		}
		return mav;
	}

	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public @ResponseBody List<AtencionMedica> validar(@RequestParam String txtAM){
		if(null == txtAM || txtAM.equals(""))return new ArrayList<AtencionMedica>();
		
		List<AtencionMedica> listaPM = atencionMedicaService.listaAM("", txtAM, "");
		return listaPM;
	}
	
}
