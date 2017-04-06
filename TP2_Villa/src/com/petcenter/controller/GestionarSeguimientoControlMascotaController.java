package com.petcenter.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.dto.SeguimientoControl;
import com.petcenter.service.SeguimientoControlService;

@Controller
@RequestMapping("/SCM")
public class GestionarSeguimientoControlMascotaController {

	private static final Log log = LogFactory.getLog(GestionarSeguimientoControlMascotaController.class);
	
	@Autowired
	SeguimientoControlService seguimientoControlService;	
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/SCMlistar");
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/SCMlistar");
		try {
			String txtFILTRO = request.getParameter("txtFILTRO");
			
			List<SeguimientoControl> listaSCM = new ArrayList<>(); 

			if(txtFILTRO.equals("1")){
				listaSCM = seguimientoControlService.verServicioAtencionMedica();
			}else if(txtFILTRO.equals("2")){
				listaSCM = seguimientoControlService.verServicioPeluqueria();
			}
			
			request.getSession().setAttribute("listaSCM", listaSCM);
			request.getSession().setAttribute("txtFILTRO", txtFILTRO);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("cliente/SCMlistar");
		request.getSession().setAttribute("listaSCM", null);
		request.getSession().setAttribute("txtFILTRO", null);
		return mav;
	}
	
	@RequestMapping("/exportar")
	public void exportar(HttpServletRequest request, HttpServletResponse response){
		String lista = request.getParameter("lista");
		List<SeguimientoControl> listaSCM = (List<SeguimientoControl>) request.getSession().getAttribute("listaSCM");
		List<SeguimientoControl> listaEXPORTAR = new ArrayList<>();
		String[] arreglo = lista.split(",");
		for (int i = 0; i < arreglo.length; i++) {
			String idMascota = arreglo[i];
			for (SeguimientoControl seguimientoControl : listaSCM) {
				if(idMascota.equals(String.valueOf(seguimientoControl.getIdMascota()))){
					listaEXPORTAR.add(seguimientoControl);
				}
			}
		}
		
		String nombreArchivo = "SeguimientoControl.csv";
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				nombreArchivo);
		response.setHeader(headerKey, headerValue);
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("Apellidos y Nombres,Mascota,Especie,Fecha Ultima Atencion").append(System.lineSeparator());
			for (SeguimientoControl sc : listaEXPORTAR) {
				sb.append(sc.getDatosCliente()).append(",");
				sb.append(sc.getDatosMascota()).append(",");
				sb.append(sc.getDescripcionEspecie()).append(",");
				sb.append(sc.getFechaUltimaAtencion()).append(System.lineSeparator());
			}
			
			InputStream input = new ByteArrayInputStream(sb.toString().getBytes("UTF8"));

	        int read = 0;
	        byte[] bytes = new byte[1024];
	        OutputStream os = response.getOutputStream();

	        while ((read = input.read(bytes)) != -1) {
	            os.write(bytes, 0, read);
	        }
	        os.flush();
	        os.close();	
		} catch (Exception e) {
			log.error(e);
		}
	}
	
//	@RequestMapping(value = "/validar", method = RequestMethod.GET)
//	public @ResponseBody List<Cliente> validar(@RequestParam String tipoDoc, @RequestParam String numDoc){
//		List<Cliente> datos = clienteService.listaCliente(tipoDoc, numDoc, "", "", "", "");
//		return datos;
//	}
	
}
