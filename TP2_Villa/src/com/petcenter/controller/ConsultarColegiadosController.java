package com.petcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcenter.dto.ColegiadoDTO;
import com.petcenter.service.ColegiadoService;

@Controller
@RequestMapping("/consultarColegiaturas")
public class ConsultarColegiadosController {

	@Autowired
	private ColegiadoService colegiadoService;

	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model) {

		return "laboratorio/consultarColegiados";
	}

	@RequestMapping(value = "/consultarColegiados", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public @ResponseBody List<ColegiadoDTO> consultarColegiados(@RequestParam("numeroColegiatura") String numeroColegiatura, 
															    @RequestParam("nombre") String nombre, 
															    @RequestParam("apellidoPaterno") String apellidoPaterno, 
															    @RequestParam("apellidoMaterno") String apellidoMaterno, 
															    Model model) {
		List<ColegiadoDTO> lista = colegiadoService.consultarColegiados(numeroColegiatura, nombre, apellidoPaterno, apellidoMaterno);
		return lista;
	}
	
	@RequestMapping(value = "/recuperarColegiado", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public @ResponseBody ColegiadoDTO recuperarColegiado(@RequestParam("numeroColegiatura") String numeroColegiatura, 
														 Model model) {
		return colegiadoService.recuperarColegiado(numeroColegiatura);
	}

}
