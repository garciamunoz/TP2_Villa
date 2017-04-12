package com.petcenter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petcenter.dto.PrecioExamenDTO;
import com.petcenter.dto.TipoExamenDTO;
import com.petcenter.service.ActualizarTipoExamenMedicoService;
import com.petcenter.service.CommonService;
import com.petcenter.service.PrecioExamenService;

@Controller
@RequestMapping("/actualizarPrecioExamen")
public class ActualizarPrecioExamenController {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private PrecioExamenService precioExamenService;
	
	@Autowired
	private ActualizarTipoExamenMedicoService actualizarTipoExamenMedicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inicio(Model model){
		
		model.addAttribute("monedas", commonService.listaMonedas());
		
		return "laboratorio/actualizarPrecioExamen";
	}
	
	@RequestMapping(value="/consultarPreciosExamenes",
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody List<TipoExamenDTO> consultarPreciosExamenes(@RequestParam("nombreExamenClinico") String nombreExamenClinico, 
																	  @RequestParam(value="idMoneda", required=false) String idMoneda, 
																	  @RequestParam(value="fechaInicial", required=false) String fechaInicial, 
																	  @RequestParam(value="fechaFinal", required=false) String fechaFinal, 
																	  Model model) {
		List<TipoExamenDTO> lista = precioExamenService.consultarPreciosExamenes(nombreExamenClinico, idMoneda, fechaInicial, fechaFinal);
		return lista;
	}
	
	@RequestMapping(value="/nuevoPrecioMedico", method = RequestMethod.GET)
	public String nuevoPrecioMedico(@RequestParam("idExamenClinico") String idExamenClinico, 
									@RequestParam("fechaInicial") String fechaInicial, 
									@RequestParam("fechaFinal") String fechaFinal, 
									Model model){ 
		model.addAttribute("accion", "nuevo");
		model.addAttribute("tipoExamen", actualizarTipoExamenMedicoService.recuperarTipoExamen(idExamenClinico));
		//model.addAttribute("precioExamen", precioExamenService.recuperarPrecioExamen(idExamenClinico, fechaInicial, fechaFinal));
		model.addAttribute("monedas", commonService.listaMonedas());
		
		return "laboratorio/nuevoEditarPrecioExamen";
	}
	
	@RequestMapping(value="/existenPreciosExamenRango",
    produces="application/json; charset=UTF-8",
    method=RequestMethod.GET)
	public @ResponseBody boolean existenPreciosExamenRango(@RequestParam("idExamenClinico") String idExamenClinico, 
														   @RequestParam("fechaInicial") String fechaInicial, 
														   @RequestParam("fechaFinal") String fechaFinal, 
														   Model model) {
		return precioExamenService.existenPreciosExamenRango(idExamenClinico, fechaInicial, fechaFinal);
	}
	
	/*@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }*/
	
	@RequestMapping(value="/registrarPrecioExamen", method=RequestMethod.GET)
	public @ResponseBody String registrarPrecioExamen(@RequestParam("idExamenClinico") String idExamenClinico, 
													  @RequestParam("fechaInicial") String fechaInicial, 
													  @RequestParam("fechaFinal") String fechaFinal, 
													  @RequestParam("idMoneda") String idMoneda, 
													  @RequestParam("precio") Double precio, 
													  @RequestParam("descuento") Double descuento) throws Exception{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		PrecioExamenDTO precioExamen = new PrecioExamenDTO();
		
		precioExamen.setIdExamenClinico(idExamenClinico);
		precioExamen.setFechaInicial(dateFormat.parse(fechaInicial));
		precioExamen.setFechaFinal(dateFormat.parse(fechaFinal));
		precioExamen.setIdMoneda(idMoneda);
		precioExamen.setPrecio(precio);
		precioExamen.setDescuento(descuento);
		
		precioExamenService.registrarPrecioExamen(precioExamen);
		
		return "OK";
	}
	
	@RequestMapping(value="/editarPrecioMedico", method = RequestMethod.GET)
	public String editarPrecioMedico(@RequestParam("idExamenClinico") String idExamenClinico, 
									 @RequestParam("fechaInicial") String fechaInicial, 
									 @RequestParam("fechaFinal") String fechaFinal, 
									 Model model){ 
		model.addAttribute("accion", "editar");
		model.addAttribute("tipoExamen", actualizarTipoExamenMedicoService.recuperarTipoExamen(idExamenClinico));
		model.addAttribute("precioExamen", precioExamenService.recuperarPrecioExamen(idExamenClinico, fechaInicial, fechaFinal));
		model.addAttribute("monedas", commonService.listaMonedas());
		
		return "laboratorio/nuevoEditarPrecioExamen";
	}
	
	@RequestMapping(value="/actualizarPrecioExamen", method=RequestMethod.GET)
	public @ResponseBody String actualizarPrecioExamen(@RequestParam("idExamenClinico") String idExamenClinico, 
													  @RequestParam("fechaInicial") String fechaInicial, 
													  @RequestParam("fechaFinal") String fechaFinal, 
													  @RequestParam("idMoneda") String idMoneda, 
													  @RequestParam("precio") Double precio, 
													  @RequestParam("descuento") Double descuento) throws Exception{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		PrecioExamenDTO precioExamen = new PrecioExamenDTO();
		
		precioExamen.setIdExamenClinico(idExamenClinico);
		precioExamen.setFechaInicial(dateFormat.parse(fechaInicial));
		precioExamen.setFechaFinal(dateFormat.parse(fechaFinal));
		precioExamen.setIdMoneda(idMoneda);
		precioExamen.setPrecio(precio);
		precioExamen.setDescuento(descuento);
		
		precioExamenService.actualizarPrecioExamen(precioExamen);
		
		return "OK";
	}
	
	@RequestMapping(value="/recuperarPrecioExamenVigente", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody PrecioExamenDTO recuperarPrecioExamenVigente(@RequestParam String idExamenClinico) throws Exception{
		
		return precioExamenService.recuperarPrecioExamenVigente(idExamenClinico);
	}

}
