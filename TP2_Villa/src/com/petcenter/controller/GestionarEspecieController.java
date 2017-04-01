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

import com.petcenter.dto.Especie;
import com.petcenter.service.EspecieService;

@Controller
@RequestMapping("/ESPE")
public class GestionarEspecieController {

	private static final Log log = LogFactory.getLog(GestionarEspecieController.class);
	
	@Autowired
	private EspecieService especieService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/ESPElistar");
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/ESPEregistrar");
		try {
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/ESPElistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("cliente/ESPEbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/ESPElistar");
		try {

			String txtDESC = request.getParameter("txtDESC");
			String observacion = request.getParameter("txtOBS");
			
			Especie obj = new Especie();
			obj.setDescripcionEspecie(txtDESC);
			obj.setObservacion(observacion);
			
			especieService.registrarEspecie(obj);
			
			List<Especie> listaESPE = especieService.listaEspecie(String.valueOf(obj.getIdEspecie()), "");
			
			request.getSession().setAttribute("listaESPE", listaESPE);
			request.getSession().setAttribute("txtESPE", obj.getIdEspecie());
			request.getSession().setAttribute("txtDESC", null);
			
			mav.addObject("mensaje", "Se registró la Especie con código: "+obj.getIdEspecie());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/ESPEregistrar");
		}
		return mav;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public ModelAndView actualizar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/ESPElistar");
		try {

			String idESPE = request.getParameter("hdnESPE");
			String observacion = request.getParameter("txtOBS");
			
			int resultado = especieService.actualizarEspecie(Integer.parseInt(idESPE), observacion);
			if(resultado > 0){
				List<Especie> listaESPE = especieService.listaEspecie(idESPE, "");
				
				request.getSession().setAttribute("listaESPE", listaESPE);
				request.getSession().setAttribute("txtESPE", idESPE);
				request.getSession().setAttribute("txtDESC", null);
				
				mav.addObject("mensaje", "Se actualizó la Especie con código: "+idESPE);
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/ESPEregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/ESPElistar");
		try {
			String txtESPE = request.getParameter("txtESPE");
			String txtDESC = request.getParameter("txtDESC");
			
			List<Especie> listaESPE = especieService.listaEspecie(txtESPE, txtDESC);
			
			request.getSession().setAttribute("listaESPE", listaESPE);
			request.getSession().setAttribute("txtESPE", txtESPE);
			request.getSession().setAttribute("txtDESC", txtDESC);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idESPE){
		ModelAndView mav = new ModelAndView("cliente/ESPEdetalle");
		try {
			Especie ESPE = especieService.verEspecie(idESPE);
			mav.addObject("ESPE", ESPE);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/ESPElistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/ESPElistar");
		request.getSession().setAttribute("listaESPE", null);
		request.getSession().setAttribute("txtESPE", null);
		request.getSession().setAttribute("txtDESC", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idESPE){
		ModelAndView mav = new ModelAndView("cliente/ESPElistar");
		try {
			int resultado = especieService.eliminarEspecie(idESPE);
			if(resultado>0){
				mav.addObject("mensaje", "Se eliminó correctamente la Especie con código: "+idESPE);

				String txtESPE = (String) request.getSession().getAttribute("txtESPE");
				String txtDESC = (String) request.getSession().getAttribute("txtDESC");
				
				List<Especie> listaESPE = especieService.listaEspecie(txtESPE, txtDESC);
				
				request.getSession().setAttribute("listaESPE", listaESPE);
				
			}else{
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
		} catch (Exception e) {
			log.error(e);
		}
		return mav;
	}
	
}
