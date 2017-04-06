package com.petcenter.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.petcenter.dto.Cliente;
import com.petcenter.dto.Mascota;
import com.petcenter.service.ClienteService;
import com.petcenter.service.CommonService;
import com.petcenter.service.MascotaService;

@Controller
@RequestMapping("/MA")
public class GestionarMascotaController {

	private static final Log log = LogFactory.getLog(GestionarMascotaController.class);
	
	@Autowired
	private MascotaService mascotaService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/MAlistar");
		request.getSession().setAttribute("listaTipoDoc", commonService.listaTipoDoc());
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/MAregistrar");
		try {
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/MAlistar");
		}
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/MAlistar");
		try {

			String idCliente = request.getParameter("hdnIDCLIENTE");
			String idRelClienteMascota = request.getParameter("idRelClienteMascota");
			String nomMascota = request.getParameter("nomMascota");
			String idRaza = request.getParameter("idRaza");
			String descMascota = request.getParameter("descMascota");
			String idGeneroMascota = request.getParameter("idGeneroMascota");
			String fechaNacMascota = request.getParameter("fechaNacMascota");
			
			Mascota mascota = new Mascota();
			mascota.setIdCliente(Integer.parseInt(idCliente));
			mascota.setIdRelClienteMascota(Integer.parseInt(idRelClienteMascota));
			mascota.setNomMascota(nomMascota);
			mascota.setIdRaza(Integer.parseInt(idRaza));
			mascota.setDescMascota(descMascota);
			mascota.setIdGeneroMascota(Integer.parseInt(idGeneroMascota));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        Date parse = format.parse(fechaNacMascota);
	        java.sql.Date sql = new java.sql.Date(parse.getTime());
			mascota.setFechaNacMascota(sql);
			
			String cod = ""+new Date().getTime();
			cod = cod.substring(cod.length()-10, cod.length());
			
			mascota.setCodMascota(cod);
			
			mascotaService.registrarMascota(mascota);
			
			if(mascota.getIdMascota() < 1){
				mav.addObject("mensaje", "Ocurrrió un error al registrar la Mascota.");
				mav.setViewName("cliente/MAregistrar");
				return mav;
			}
			
			List<Mascota> listaMA = mascotaService.listaMascota("","",String.valueOf(mascota.getIdMascota()),"","","","","");
			
			request.getSession().setAttribute("listaMA", listaMA);
			request.getSession().setAttribute("txtCOD", null);
			request.getSession().setAttribute("txtCODMASCOTA", String.valueOf(mascota.getIdMascota()));
			request.getSession().setAttribute("txtTIPODOC", null);
			request.getSession().setAttribute("txtNRODOC", null);
			request.getSession().setAttribute("txtNOMBRE", null);
			request.getSession().setAttribute("txtNOMBREMASCOTA", null);
			request.getSession().setAttribute("txtAP", null);
			request.getSession().setAttribute("txtAM", null);
			
			mav.addObject("mensaje", "Se registró la Mascota con código: "+mascota.getIdMascota());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/MAregistrar");
		}
		return mav;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public ModelAndView actualizar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/MAlistar");
		try {

			String idMascota = request.getParameter("hdnMA");
			String codMascota = request.getParameter("hdnCODMA");
			String idCliente = request.getParameter("hdnCLI");
			String idRelClienteMascota = request.getParameter("idRelClienteMascota");
			String nomMascota = request.getParameter("nomMascota");
			String idRaza = request.getParameter("idRaza");
			String descMascota = request.getParameter("descMascota");
			String idGeneroMascota = request.getParameter("idGeneroMascota");
			String fechaNacMascota = request.getParameter("fechaNacMascota");
			String estadoMascota = request.getParameter("estadoMascota");
			
			Mascota mascota = new Mascota();
			mascota.setIdMascota(Integer.parseInt(idMascota));
			mascota.setCodMascota(codMascota);
			mascota.setIdCliente(Integer.parseInt(idCliente));
			mascota.setIdRelClienteMascota(Integer.parseInt(idRelClienteMascota));
			mascota.setNomMascota(nomMascota);
			mascota.setIdRaza(Integer.parseInt(idRaza));
			mascota.setDescMascota(descMascota);
			mascota.setIdGeneroMascota(Integer.parseInt(idGeneroMascota));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        Date parse = format.parse(fechaNacMascota);
	        java.sql.Date sql = new java.sql.Date(parse.getTime());
			mascota.setFechaNacMascota(sql);
			mascota.setEstadoMascota(Integer.parseInt(estadoMascota));
			
			int resultado = mascotaService.actualizarMascota(mascota);
			
			if(resultado > 0){
				List<Mascota> listaMA = mascotaService.listaMascota("","",String.valueOf(mascota.getIdMascota()),"","","","","");
				
				request.getSession().setAttribute("listaMA", listaMA);
				request.getSession().setAttribute("txtCOD", null);
				request.getSession().setAttribute("txtCODMASCOTA", String.valueOf(mascota.getIdMascota()));
				request.getSession().setAttribute("txtTIPODOC", null);
				request.getSession().setAttribute("txtAM", null);
				request.getSession().setAttribute("txtNRODOC", null);
				request.getSession().setAttribute("txtNOMBRE", null);
				request.getSession().setAttribute("txtNOMBREMASCOTA", null);
				request.getSession().setAttribute("txtAP", null);
				request.getSession().setAttribute("txtAM", null);
				
				mav.addObject("mensaje", "Se actualizó la Mascota con código: "+mascota.getIdMascota());
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/MAdetalle");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/MAlistar");
		try {
			String txtTIPODOC = request.getParameter("txtTIPODOC");
			String txtNRODOC = request.getParameter("txtNRODOC");
			String txtNOMBRE = request.getParameter("txtNOMBRE");
			String txtNOMBREMASCOTA = request.getParameter("txtNOMBREMASCOTA");
			String txtAP = request.getParameter("txtAP");
			String txtCOD = request.getParameter("txtCOD");
			String txtCODMASCOTA = request.getParameter("txtCODMASCOTA");
			String txtAM = request.getParameter("txtAM");
			
			List<Mascota> listaMA = mascotaService.listaMascota(txtTIPODOC,txtNRODOC,txtCODMASCOTA,txtNOMBREMASCOTA,txtAP,txtAM,txtCOD,txtNOMBRE);
			
			request.getSession().setAttribute("listaMA", listaMA);
			request.getSession().setAttribute("txtCOD", txtCOD);
			request.getSession().setAttribute("txtCODMASCOTA", txtCODMASCOTA);
			request.getSession().setAttribute("txtTIPODOC", txtTIPODOC);
			request.getSession().setAttribute("txtNRODOC", txtNRODOC);
			request.getSession().setAttribute("txtNOMBRE", txtNOMBRE);
			request.getSession().setAttribute("txtNOMBREMASCOTA", txtNOMBREMASCOTA);
			request.getSession().setAttribute("txtAP", txtAP);
			request.getSession().setAttribute("txtAM", txtAM);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idMA){
		ModelAndView mav = new ModelAndView("cliente/MAdetalle");
		try {
			Mascota MA = mascotaService.verMascota(idMA);
			mav.addObject("MA", MA);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/MAlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/MAlistar");
		request.getSession().setAttribute("listaMA", null);
		request.getSession().setAttribute("txtCOD", null);
		request.getSession().setAttribute("txtCODMASCOTA", null);
		request.getSession().setAttribute("txtTIPODOC", null);
		request.getSession().setAttribute("txtAM", null);
		request.getSession().setAttribute("txtNRODOC", null);
		request.getSession().setAttribute("txtNOMBRE", null);
		request.getSession().setAttribute("txtNOMBREMASCOTA", null);
		request.getSession().setAttribute("txtAP", null);
		request.getSession().setAttribute("txtAM", null);
		return mav;
	}
	
//	@RequestMapping("/eliminar")
//	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idMA){
//		ModelAndView mav = new ModelAndView("cliente/MAlistar");
//		try {
//			int resultado = mascotaService.eliminarMascota(idMA);
//			if(resultado>0){
//					mav.addObject("mensaje", "Se eliminó correctamente la Mascota con código: "+idMA);
//			}else{
//				log.error("No se elimino el Mascota.");
//				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
//			}
//			
//			String txtCOD = (String) request.getSession().getAttribute("txtCOD");
//			String txtCODMASCOTA = (String) request.getSession().getAttribute("txtCODMASCOTA");
//			String txtTIPODOC = (String) request.getSession().getAttribute("txtTIPODOC");
//			String txtNRODOC = (String) request.getSession().getAttribute("txtNRODOC");
//			String txtNOMBRE = (String) request.getSession().getAttribute("txtNOMBRE");
//			String txtNOMBREMASCOTA = (String) request.getSession().getAttribute("txtNOMBREMASCOTA");
//			String txtAP = (String) request.getSession().getAttribute("txtAP");
//			String txtAM = (String) request.getSession().getAttribute("txtAM");
//			
//			List<Mascota> listaMA = mascotaService.listaMascota(txtTIPODOC, txtNRODOC, txtCODMASCOTA, txtNOMBREMASCOTA, txtAP, txtAM, txtCOD, txtNOMBRE);
//			
//			request.getSession().setAttribute("listaMA", listaMA);
//			
//		} catch (Exception e) {
//			log.error(e);
//		}
//		return mav;
//	}

	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public @ResponseBody List<Cliente> validar(@RequestParam String tipoDoc, @RequestParam String numDoc){
		List<Cliente> datos = clienteService.listaCliente(tipoDoc, numDoc, "", "", "", "");
		return datos;
	}
	
}
