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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petcenter.dto.AtencionMedica;
import com.petcenter.dto.DatosClienteMascota;
import com.petcenter.service.AtencionMedicaService;
import com.petcenter.service.CommonService;
import com.petcenter.service.HistoriaClinicaService;
import com.petcenter.util.Constante;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Controller
@RequestMapping("/AM")
public class GestionarAtencionMedicaController {

	private static final Log log = LogFactory.getLog(GestionarAtencionMedicaController.class);
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private HistoriaClinicaService historiaClinicaService;

	@Autowired
	private AtencionMedicaService atencionMedicaService;
	
	@RequestMapping("/inicio")
	public ModelAndView listar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		request.getSession().setAttribute("codigoMedico", 1);
		request.getSession().setAttribute("datosMedico", "Doc. Vet Corbalan");
		return mav;
	}
	
	@RequestMapping("/cargarRegistrar")
	public ModelAndView cargarRegistrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMregistrar");
		try {
			request.getSession().setAttribute("listaTipoDoc", commonService.listaTipoDoc());
			request.getSession().setAttribute("listaExamenes", atencionMedicaService.listaExamenes());
			request.getSession().setAttribute("listaDiagnostico", atencionMedicaService.listaDiagnostico());
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/AMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/cargarBuscar")
	public ModelAndView cargarBuscar(){
		ModelAndView mav = new ModelAndView("medica/AMbuscar");
		return mav;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ModelAndView registrar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		try {

			String txtHC = request.getParameter("txtHC");			
			String codMEDICO = request.getSession().getAttribute("codigoMedico").toString();
			String desMEDICO = request.getSession().getAttribute("datosMedico").toString();
			String idDIAG = request.getParameter("txtDIAG");
			String idEXAM = request.getParameter("txtEXAMEN");
			String deposiciones = request.getParameter("txtDEPO");
			String peso = request.getParameter("txtPESO");
			String temperatura = request.getParameter("txtTEMP");
			String signovital = request.getParameter("txtVITAL");
			String observacion = request.getParameter("txtOBS");
			String comentario = request.getParameter("txtCOMMENT");
			
			AtencionMedica AM = new AtencionMedica();
			AM.setIdHC(Integer.parseInt(txtHC));
			AM.setCodMedico(Integer.parseInt(codMEDICO));
			AM.setComentario(comentario);
			AM.setDeposiciones(Integer.parseInt(deposiciones));
			AM.setDesMedico(desMEDICO);
			AM.setEstadoAM(Constante.ESTADO_ACTIVO);
			AM.setIdDIAG(Integer.parseInt(idDIAG));
			AM.setIdEXAM(Integer.parseInt(idEXAM));
			AM.setObservacion(observacion);
			AM.setPeso(Double.parseDouble(peso));
			AM.setSignovital(Integer.parseInt(signovital));
			AM.setTemperatura(Integer.parseInt(temperatura));
				
			atencionMedicaService.registrarAM(AM);
			
			List<AtencionMedica> listaAM = atencionMedicaService.listaAM("", String.valueOf(AM.getIdAM()), "");
			
			request.getSession().setAttribute("listaAM", listaAM);
			request.getSession().setAttribute("txtHC", null);
			request.getSession().setAttribute("txtAM", AM.getIdAM());
			request.getSession().setAttribute("txtNUMDOC", null);
			
			mav.addObject("mensaje", "Se registró la Atención Médica con código: "+AM.getIdAM());
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrió un error en el Sistema.");
			mav.setViewName("medica/AMregistrar");
		}
		return mav;
	}
	
	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		try {
			String txtHC = request.getParameter("txtHC");
			String txtAM = request.getParameter("txtAM");
			String txtNUMDOC = request.getParameter("txtNUMDOC");

			List<AtencionMedica> listaAM = atencionMedicaService.listaAM(txtHC, txtAM, txtNUMDOC);
			
			request.getSession().setAttribute("listaAM", listaAM);
			request.getSession().setAttribute("txtHC", txtHC);
			request.getSession().setAttribute("txtAM", txtAM);
			request.getSession().setAttribute("txtNUMDOC", txtNUMDOC);
			
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
		}
		return mav;
	}
	
	@RequestMapping("/detalle")
	public ModelAndView detalle(@RequestParam int idAM){
		ModelAndView mav = new ModelAndView("medica/AMdetalle");
		try {
			AtencionMedica AM = atencionMedicaService.verAM(idAM);
			mav.addObject("AM", AM);
		} catch (Exception e) {
			log.error(e);
			mav.addObject("mensaje", "Ocurrrio un error en el Sistema");
			mav.setViewName("medica/AMlistar");
		}
		return mav;
	}
	
	@RequestMapping("/limpiar")
	public ModelAndView limpiar(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		request.getSession().setAttribute("listaAM", null);
		request.getSession().setAttribute("txtAM", null);
		request.getSession().setAttribute("txtNUMDOC", null);
		return mav;
	}
	
	@RequestMapping("/eliminar")
	public ModelAndView eliminar(HttpServletRequest request, @RequestParam int idAM){
		ModelAndView mav = new ModelAndView("medica/AMlistar");
		try {
			int resultado = atencionMedicaService.eliminarAM(idAM);
			if(resultado>0){
				mav.addObject("mensaje", "Se eliminó correctamente la Atención Médica con codigo: "+idAM);

				String txtHC = (String) request.getSession().getAttribute("txtHC");
				String txtAM = (String) request.getSession().getAttribute("txtAM");
				String txtNUMDOC = (String) request.getSession().getAttribute("txtNUMDOC");
				
				List<AtencionMedica> listaAM = atencionMedicaService.listaAM(txtHC, txtAM, txtNUMDOC);
				
				request.getSession().setAttribute("listaAM", listaAM);
				
			}else{
				mav.addObject("mensaje", "Ocurrió un error en el Sistema.");
			}
		} catch (Exception e) {
			log.error(e);
		}
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
