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

import com.petcenter.dto.Raza;
import com.petcenter.service.EspecieService;
import com.petcenter.service.RazaService;

@Controller
@RequestMapping("/RAZA")
public class GestionarRazaController {

	private static final Log log = LogFactory.getLog(GestionarRazaController.class);
	
	@Autowired
	private RazaService razaService;
	
	@Autowired
	private EspecieService especieService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/RAZAlistar");
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/RAZAregistrar");
		try {
			request.getSession().setAttribute("listaESPE", especieService.listaEspecie("", ""));
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/RAZAlistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("cliente/RAZAbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/RAZAlistar");
		try {

			String txtDESC = request.getParameter("txtDESC");
			String observacion = request.getParameter("txtOBS");
			String idEspecie = request.getParameter("txtESPE");
			
			Raza obj = new Raza();
			obj.setDescripcionRaza(txtDESC);
			obj.setObservacion(observacion);
			obj.setIdEspecie(Integer.parseInt(idEspecie));
			
			razaService.registrarRaza(obj);
			
			List<Raza> listaRAZA = razaService.listaRaza(String.valueOf(obj.getIdRaza()), "");
			
			request.getSession().setAttribute("listaRAZA", listaRAZA);
			request.getSession().setAttribute("txtRAZA", obj.getIdRaza());
			request.getSession().setAttribute("txtDESC", null);
			
			mav.addObject("mensaje", "Se registró la Raza con código: "+obj.getIdRaza());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/RAZAregistrar");
		}
		return mav;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public ModelAndView actualizar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/RAZAlistar");
		try {

			String idRAZA = request.getParameter("hdnRAZA");
			String observacion = request.getParameter("txtOBS");
			String idEspecie = request.getParameter("txtESPE");
			
			int resultado = razaService.actualizarRaza(Integer.parseInt(idRAZA), observacion, idEspecie);
			if(resultado > 0){
				List<Raza> listaRAZA = razaService.listaRaza(idRAZA, "");
				
				request.getSession().setAttribute("listaRAZA", listaRAZA);
				request.getSession().setAttribute("txtRAZA", idRAZA);
				request.getSession().setAttribute("txtDESC", null);
				
				mav.addObject("mensaje", "Se actualizó la Raza con código: "+idRAZA);
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/RAZAregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/RAZAlistar");
		try {
			String txtRAZA = request.getParameter("txtRAZA");
			String txtDESC = request.getParameter("txtDESC");
			
			List<Raza> listaRAZA = razaService.listaRaza(txtRAZA, txtDESC);
			
			request.getSession().setAttribute("listaRAZA", listaRAZA);
			request.getSession().setAttribute("txtRAZA", txtRAZA);
			request.getSession().setAttribute("txtDESC", txtDESC);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idRAZA, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/RAZAdetalle");
		try {
			Raza RAZA = razaService.verRaza(idRAZA);
			mav.addObject("RAZA", RAZA);
			request.getSession().setAttribute("listaESPE", especieService.listaEspecie("", ""));
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/RAZAlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/RAZAlistar");
		request.getSession().setAttribute("listaRAZA", null);
		request.getSession().setAttribute("txtRAZA", null);
		request.getSession().setAttribute("txtDESC", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idRAZA){
		ModelAndView mav = new ModelAndView("cliente/RAZAlistar");
		try {
			int resultado = razaService.eliminarRaza(idRAZA);
			if(resultado>0){
				mav.addObject("mensaje", "Se eliminó correctamente la Raza con código: "+idRAZA);

				String txtRAZA = (String) request.getSession().getAttribute("txtRAZA");
				String txtDESC = (String) request.getSession().getAttribute("txtDESC");
				
				List<Raza> listaRAZA = razaService.listaRaza(txtRAZA, txtDESC);
				
				request.getSession().setAttribute("listaRAZA", listaRAZA);
				
			}else{
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
		} catch (Exception e) {
			log.error(e);
		}
		return mav;
	}
	
}
