package com.petcenter.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.petcenter.service.ClienteService;
import com.petcenter.service.CommonService;

@Controller
@RequestMapping("/CLI")
public class GestionarClienteController {

	private static final Log log = LogFactory.getLog(GestionarClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/CLIlistar");
		request.getSession().setAttribute("listaTipoDoc", commonService.listaTipoDoc());
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/CLIregistrar");
		try {
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/CLIlistar");
		}
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/CLIlistar");
		try {

			String idTipoCliente = request.getParameter("idTipoCliente");
			String idTipoDocumento = request.getParameter("idTipoDocumento");
			String nroDocumento = request.getParameter("nroDocumento");
			String nomCliente = request.getParameter("nomCliente");
			String apePaternoCliente = request.getParameter("apePaternoCliente");
			String apeMaternoCliente = request.getParameter("apeMaternoCliente");
			String idGeneroCliente = request.getParameter("idGeneroCliente");
			String fecNacCliente = request.getParameter("fecNacCliente");
			String idSede = request.getParameter("idSede");
			String idDistrito = request.getParameter("idDistrito");
			String direcCliente = request.getParameter("direcCliente");
			String celCliente = request.getParameter("celCliente");
			String telfDomCliente = request.getParameter("telfDomCliente");
			String telfTraCliente = request.getParameter("telfTraCliente");
			String indNotificaciones = request.getParameter("indNotificaciones");
			String correoElectCliente = request.getParameter("correoElectCliente");
			
			Cliente cliente = new Cliente();
			cliente.setIdTipoCliente(Integer.parseInt(idTipoCliente));
			cliente.setIdTipoDocumento(Integer.parseInt(idTipoDocumento));
			cliente.setNroDocumento(nroDocumento);
			cliente.setNomCliente(nomCliente);
			cliente.setApePaternoCliente(apePaternoCliente);
			cliente.setApeMaternoCliente(apeMaternoCliente);
			cliente.setIdGeneroCliente(Integer.parseInt(idGeneroCliente));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        Date parse = format.parse(fecNacCliente);
	        java.sql.Date sql = new java.sql.Date(parse.getTime());
			cliente.setFecNacCliente(sql);
			cliente.setIdSede(Integer.parseInt(idSede));
			cliente.setIdDistrito(Integer.parseInt(idDistrito));
			cliente.setDirecCliente(direcCliente);
			cliente.setCelCliente(celCliente);
			cliente.setTelfDomCliente(telfDomCliente);
			cliente.setTelfTraCliente(telfTraCliente);
			cliente.setIndNotificaciones(Integer.parseInt(indNotificaciones));
			cliente.setCorreoElectCliente(correoElectCliente);
			
			String cod = ""+new Date().getTime();
			cod = cod.substring(cod.length()-10, cod.length());
			
			cliente.setCodCliente(cod);
			
			clienteService.registrarCliente(cliente);
			
			if(cliente.getIdCliente() < 1){
				mav.addObject("mensaje", "Ocurrrió un error al registrar el Cliente.");
				mav.setViewName("cliente/CLIregistrar");
				return mav;
			}
			
			List<Cliente> listaCLI = clienteService.listaCliente("","",String.valueOf(cliente.getIdCliente()),"","","");
			
			request.getSession().setAttribute("listaCLI", listaCLI);
			request.getSession().setAttribute("txtCOD", String.valueOf(cliente.getIdCliente()));
			request.getSession().setAttribute("txtTIPODOC", null);
			request.getSession().setAttribute("txtAM", null);
			request.getSession().setAttribute("txtNRODOC", null);
			request.getSession().setAttribute("txtNOMBRE", null);
			request.getSession().setAttribute("txtAP", null);
			request.getSession().setAttribute("txtAM", null);
			
			mav.addObject("mensaje", "Se registró el Cliente con código: "+cliente.getIdCliente());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/CLIregistrar");
		}
		return mav;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	public ModelAndView actualizar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/CLIlistar");
		try {

			String idCliente = request.getParameter("hdnCLI");
			String codCliente = request.getParameter("hdnCODCLI");
			String idTipoCliente = request.getParameter("idTipoCliente");
			String idTipoDocumento = request.getParameter("idTipoDocumento");
			String nroDocumento = request.getParameter("nroDocumento");
			String nomCliente = request.getParameter("nomCliente");
			String apePaternoCliente = request.getParameter("apePaternoCliente");
			String apeMaternoCliente = request.getParameter("apeMaternoCliente");
			String idGeneroCliente = request.getParameter("idGeneroCliente");
			String fecNacCliente = request.getParameter("fecNacCliente");
			String idSede = request.getParameter("idSede");
			String idDistrito = request.getParameter("idDistrito");
			String direcCliente = request.getParameter("direcCliente");
			String celCliente = request.getParameter("celCliente");
			String telfDomCliente = request.getParameter("telfDomCliente");
			String telfTraCliente = request.getParameter("telfTraCliente");
			String indNotificaciones = request.getParameter("indNotificaciones");
			String correoElectCliente = request.getParameter("correoElectCliente");
			
			Cliente cliente = new Cliente();
			cliente.setIdCliente(Integer.parseInt(idCliente));
			cliente.setCodCliente(codCliente);
			cliente.setIdTipoCliente(Integer.parseInt(idTipoCliente));
			cliente.setIdTipoDocumento(Integer.parseInt(idTipoDocumento));
			cliente.setNroDocumento(nroDocumento);
			cliente.setNomCliente(nomCliente);
			cliente.setApePaternoCliente(apePaternoCliente);
			cliente.setApeMaternoCliente(apeMaternoCliente);
			cliente.setIdGeneroCliente(Integer.parseInt(idGeneroCliente));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        Date parse = format.parse(fecNacCliente);
	        java.sql.Date sql = new java.sql.Date(parse.getTime());
			cliente.setFecNacCliente(sql);
			cliente.setIdSede(Integer.parseInt(idSede));
			cliente.setIdDistrito(Integer.parseInt(idDistrito));
			cliente.setDirecCliente(direcCliente);
			cliente.setCelCliente(celCliente);
			cliente.setTelfDomCliente(telfDomCliente);
			cliente.setTelfTraCliente(telfTraCliente);
			cliente.setIndNotificaciones(Integer.parseInt(indNotificaciones));
			cliente.setCorreoElectCliente(correoElectCliente);
			
			int resultado = clienteService.actualizarCliente(cliente);
			
			if(resultado > 0){
				List<Cliente> listaCLI = clienteService.listaCliente("","",String.valueOf(cliente.getIdCliente()),"","","");
				
				request.getSession().setAttribute("listaCLI", listaCLI);
				request.getSession().setAttribute("txtCOD", String.valueOf(cliente.getIdCliente()));
				request.getSession().setAttribute("txtTIPODOC", null);
				request.getSession().setAttribute("txtAM", null);
				request.getSession().setAttribute("txtNRODOC", null);
				request.getSession().setAttribute("txtNOMBRE", null);
				request.getSession().setAttribute("txtAP", null);
				request.getSession().setAttribute("txtAM", null);
				
				mav.addObject("mensaje", "Se actualizó el Cliente con código: "+cliente.getIdCliente());
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("cliente/CLIdetalle");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/CLIlistar");
		try {
			String txtTIPODOC = request.getParameter("txtTIPODOC");
			String txtNRODOC = request.getParameter("txtNRODOC");
			String txtNOMBRE = request.getParameter("txtNOMBRE");
			String txtAP = request.getParameter("txtAP");
			String txtCOD = request.getParameter("txtCOD");
			String txtAM = request.getParameter("txtAM");
			
			List<Cliente> listaCLI = clienteService.listaCliente(txtTIPODOC,txtNRODOC,txtCOD,txtNOMBRE,txtAP,txtAM);
			
			request.getSession().setAttribute("listaCLI", listaCLI);
			request.getSession().setAttribute("txtTIPODOC", txtTIPODOC);
			request.getSession().setAttribute("txtAM", txtAM);
			request.getSession().setAttribute("txtNRODOC", txtNRODOC);
			request.getSession().setAttribute("txtNOMBRE", txtNOMBRE);
			request.getSession().setAttribute("txtAP", txtAP);
			request.getSession().setAttribute("txtCOD", txtCOD);
			request.getSession().setAttribute("txtAM", txtAM);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idCLI){
		ModelAndView mav = new ModelAndView("cliente/CLIdetalle");
		try {
			Cliente CLI = clienteService.verCliente(idCLI);
			mav.addObject("CLI", CLI);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("cliente/CLIlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/CLIlistar");
		request.getSession().setAttribute("listaCLI", null);
		request.getSession().setAttribute("txtTIPODOC", null);
		request.getSession().setAttribute("txtAM", null);
		request.getSession().setAttribute("txtNRODOC", null);
		request.getSession().setAttribute("txtNOMBRE", null);
		request.getSession().setAttribute("txtAP", null);
		request.getSession().setAttribute("txtCOD", null);
		request.getSession().setAttribute("txtAM", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idCLI){
		ModelAndView mav = new ModelAndView("cliente/CLIlistar");
		try {
			int resultado = clienteService.eliminarCliente(idCLI);
			if(resultado>0){
					mav.addObject("mensaje", "Se eliminó correctamente el Cliente con código: "+idCLI);
			}else{
				log.error("No se elimino el Cliente.");
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
			
			String txtTIPODOC = (String) request.getSession().getAttribute("txtTIPODOC");
			String txtNRODOC = (String) request.getSession().getAttribute("txtNRODOC");
			String txtNOMBRE = (String) request.getSession().getAttribute("txtNOMBRE");
			String txtAP = (String) request.getSession().getAttribute("txtAP");
			String txtCOD = (String) request.getSession().getAttribute("txtCOD");
			String txtAM = (String) request.getSession().getAttribute("txtAM");
			
			List<Cliente> listaCLI = clienteService.listaCliente(txtTIPODOC, txtNRODOC, txtCOD, txtNOMBRE, txtAP, txtAM);
			
			request.getSession().setAttribute("listaCLI", listaCLI);
			
		} catch (Exception e) {
			log.error(e);
		}
		return mav;
	}

	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public @ResponseBody List<Cliente> validar(@RequestParam String txtNROCLI){
		if(null == txtNROCLI || txtNROCLI.equals(""))return new ArrayList<Cliente>();
		List<Cliente> listaCLI = clienteService.listaCliente("", txtNROCLI, "", "", "", "");
		return listaCLI;
	}
	
}
