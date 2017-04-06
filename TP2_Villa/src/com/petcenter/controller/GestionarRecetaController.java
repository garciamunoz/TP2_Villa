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

import com.petcenter.dto.Receta;
import com.petcenter.dto.RecetaDetalle;
import com.petcenter.service.RecetaService;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Controller
@RequestMapping("/RM")
public class GestionarRecetaController {

	private static final Log log = LogFactory.getLog(GestionarRecetaController.class);
	
	@Autowired
	private RecetaService recetaService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/RMlistar");
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/RMregistrar");
		try {
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/RMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/RMbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/RMlistar");
		try {

			String txtAM = request.getParameter("txtAM");
			String txtOBS = request.getParameter("txtOBS");
			
			String[] nombreMedicamento = request.getParameterValues("nombreMedicamento");
			String[] via = request.getParameterValues("via");
			String[] dosis = request.getParameterValues("dosis");
			String[] indicacion = request.getParameterValues("indicacion");
			String[] duracion = request.getParameterValues("duracion");
			String[] cantidad = request.getParameterValues("cantidad");
			
			Receta receta = new Receta();
			receta.setIdAM(Integer.parseInt(txtAM));
			receta.setObservacion(txtOBS);
			
			recetaService.registrarReceta(receta);
			
			if(receta.getIdReceta() > 0){
				int total = nombreMedicamento.length;
				for (int i = 0; i < total; i++) {
					try {
						RecetaDetalle recetaDetalle = new RecetaDetalle();
						recetaDetalle.setIdReceta(receta.getIdReceta());
						recetaDetalle.setCantidad(cantidad[i]);
						recetaDetalle.setDosis(dosis[i]);
						recetaDetalle.setDuracion(duracion[i]);
						recetaDetalle.setIndicacion(indicacion[i]);
						recetaDetalle.setNombreMedicamento(nombreMedicamento[i]);
						recetaDetalle.setVia(via[i]);
						recetaService.registrarRecetaDetalle(recetaDetalle);
					} catch (Exception e) {
						log.error("Error al registrar el detalle de la receta.", e);
					}
				}
			}else{
				mav.addObject("mensaje", "Ocurrrió un error al registrar la Receta Médica.");
				mav.setViewName("medica/RMregistrar");
				return mav;
			}
			
			List<Receta> listaRM = recetaService.listaReceta("", String.valueOf(receta.getIdAM()));
			
			request.getSession().setAttribute("listaRM", listaRM);
			request.getSession().setAttribute("txtRM", null);
			request.getSession().setAttribute("txtAM", String.valueOf(receta.getIdAM()));
			
			mav.addObject("mensaje", "Se registró la Receta Médica con código: "+receta.getIdReceta());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/RMregistrar");
		}
		return mav;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public ModelAndView actualizar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/RMlistar");
		try {

			String idRM = request.getParameter("hdnRM");
			String observacion = request.getParameter("txtOBS");
			
			int resultado = recetaService.actualizarReceta(Integer.parseInt(idRM), observacion);
			if(resultado > 0){
				List<Receta> listaRM = recetaService.listaReceta(idRM, "");
				
				request.getSession().setAttribute("listaRM", listaRM);
				request.getSession().setAttribute("txtRM", idRM);
				request.getSession().setAttribute("txtAM", null);
				
				mav.addObject("mensaje", "Se actualizó la Receta Médica con código: "+idRM);
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/RMregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/RMlistar");
		try {
			String txtRM = request.getParameter("txtRM");
			String txtAM = request.getParameter("txtAM");
			
			List<Receta> listaRM = recetaService.listaReceta(txtRM, txtAM);
			
			request.getSession().setAttribute("listaRM", listaRM);
			request.getSession().setAttribute("txtRM", txtRM);
			request.getSession().setAttribute("txtAM", txtAM);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idRM){
		ModelAndView mav = new ModelAndView("medica/RMdetalle");
		try {
			Receta RM = recetaService.verReceta(idRM);
			List<RecetaDetalle> listaRM = recetaService.listaRecetaDetalle(String.valueOf(idRM));
			
			mav.addObject("RM", RM);
			mav.addObject("listaRM", listaRM);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/RMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/RMlistar");
		request.getSession().setAttribute("listaRM", null);
		request.getSession().setAttribute("txtRM", null);
		request.getSession().setAttribute("txtAM", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idRM){
		ModelAndView mav = new ModelAndView("medica/RMlistar");
		try {
			int resultado = recetaService.eliminarReceta(idRM);
			if(resultado>0){
				int resultadoDetalle = recetaService.eliminarRecetaDetalle(idRM);
				if(resultadoDetalle>0){
					mav.addObject("mensaje", "Se eliminó correctamente la Receta Médica con código: "+idRM);
				}else{
					log.error("No se elimino el detalle de la receta medica.");
					mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
				}
			}else{
				log.error("No se elimino la receta medica.");
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
			
			List<Receta> listaRM = recetaService.listaReceta("", "");
			
			request.getSession().setAttribute("listaRM", listaRM);
			
		} catch (Exception e) {
			log.error(e);
		}
		return mav;
	}

	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public @ResponseBody List<Receta> validar(@RequestParam String txtAM){
		if(null == txtAM || txtAM.equals(""))return new ArrayList<Receta>();
		
		List<Receta> listaRM = recetaService.listaReceta("", txtAM);
		return listaRM;
	}
	
}
