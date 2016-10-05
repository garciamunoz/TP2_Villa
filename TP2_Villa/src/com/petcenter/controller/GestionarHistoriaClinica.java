package com.petcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.dto.DatosClienteMascota;
import com.petcenter.service.CommonService;
import com.petcenter.service.HistoriaClinicaService;

@Controller
@RequestMapping("/HC")
public class GestionarHistoriaClinica {

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private HistoriaClinicaService historiaClinicaService;
	
	@RequestMapping("/listar")
	public ModelAndView listar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(){
		ModelAndView mav = new ModelAndView("medica/HCregistrar");
		mav.addObject("listaTipoDoc", commonService.listaTipoDoc());
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/HCbuscar");
		
		return mav;
	}
	
	@RequestMapping("/registrar")
	public ModelAndView registrar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(){
		ModelAndView mav = new ModelAndView("medica/HCdetalle");
		
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(){
		ModelAndView mav = new ModelAndView("medica/HClistar");
		
		return mav;
	}
	
	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public @ResponseBody List<DatosClienteMascota> validar(@RequestParam String tipoDoc, @RequestParam String numDoc){
		List<DatosClienteMascota> datos = historiaClinicaService.listaClienteMascota(tipoDoc, numDoc);
//		for (DatosClienteMascota datosClienteMascota : datos) {
//			String fotoString = new String(Base64.encodeBase64(datosClienteMascota.getFotoMascota()));
//			datosClienteMascota.setFotoString(fotoString);
//		}
		return datos;
	}
	
}
