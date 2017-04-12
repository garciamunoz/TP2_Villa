package com.petcenter.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petcenter.dao.spec.EspecialidadMapper;
import com.petcenter.dao.spec.EstadoMapper;
import com.petcenter.dao.spec.EstandarMapper;
import com.petcenter.dao.spec.NormativaMapper;
import com.petcenter.dao.spec.PrecioMapper;
import com.petcenter.dao.spec.TipoExamenMedicoMapper;
import com.petcenter.dto.AtributoExamenClinicoDTO;
import com.petcenter.dto.EspecialidadDTO;
import com.petcenter.dto.EstadoDTO;
import com.petcenter.dto.EstandarDTO;
import com.petcenter.dto.NormativaDTO;
import com.petcenter.dto.PrecioDTO;
import com.petcenter.dto.PrecioExamenDTO;
import com.petcenter.dto.TipoExamenDTO;

@Service
public class ActualizarTipoExamenMedicoService {

	@Autowired
	private EspecialidadMapper especialidadMapper;
	@Autowired
	private EstadoMapper estadoMapper;
	@Autowired
	private TipoExamenMedicoMapper tipoExamenMedicoMapper;
	@Autowired
	private NormativaMapper normativaMapper;
	@Autowired
	private EstandarMapper estandarMapper;
	@Autowired
	private PrecioMapper precioMapper;
	
	@Autowired
	private PrecioExamenService precioExamenService;
	
	public List<EspecialidadDTO> listarEspecialidades(){
		return especialidadMapper.listarEspecialidades();
	}
	public List<EstadoDTO> listarEstados(){
		return estadoMapper.listaEstados();
	}
	public List<TipoExamenDTO> buscarTiposExamen(String nombre,String descripcion,String est,String esp){
		return tipoExamenMedicoMapper.buscarTiposExamen(nombre, descripcion, est, esp);
	}
	public List<NormativaDTO> listarNormativa(){
		return normativaMapper.listarNormativa();
	}
	public List<EstandarDTO> listaEstandares(){
		return estandarMapper.listaEstandares();
	}
	/*public List<PrecioDTO> listarPrecios(String mon,String startDate,String endDate) throws Exception{
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String reformattedStr = myFormat.format(fromUser.parse(startDate));
		 String reformattedStrEdnd = myFormat.format(fromUser.parse(endDate));
		return precioMapper.listarPrecios(mon,reformattedStr,reformattedStrEdnd);
	}*/
	
	public List<PrecioDTO> listaPrecios() {
		return precioMapper.listaPrecios();
	}
	
	@Transactional
	public void registrar(TipoExamenDTO tipoExamen) {
		int nuevo = tipoExamenMedicoMapper.generarNumero();
		String strNuevo = String.format("%04d", nuevo);
		
		tipoExamen.setIdExamenClinico(strNuevo);
		
		tipoExamenMedicoMapper.registrar(tipoExamen);
		
		for (AtributoExamenClinicoDTO atr : tipoExamen.getAtributos()) {
			atr.setIdExamenClinico(tipoExamen.getIdExamenClinico());
			tipoExamenMedicoMapper.registrarDetalle(atr);
		}
		
		PrecioExamenDTO precioExamen = new PrecioExamenDTO();
		precioExamen.setIdExamenClinico(strNuevo);
		precioExamen.setFechaInicial(new Date());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			precioExamen.setFechaFinal(dateFormat.parse("31-12-9999"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		precioExamen.setIdMoneda("PEN");
		precioExamen.setPrecio(0.0);
		precioExamen.setDescuento(0.0);
		
		precioExamenService.registrarPrecioExamen(precioExamen);
	}
	
	public TipoExamenDTO recuperarTipoExamen(String idExamenClinico) {
		
		TipoExamenDTO t = tipoExamenMedicoMapper.recuperarTipoExamen(idExamenClinico);
		
		List<AtributoExamenClinicoDTO> l = tipoExamenMedicoMapper.recuperarTipoExamenDetalle(idExamenClinico);
		
		t.setAtributos(l);
		
		return t;
	}
	
	public void actualizar(TipoExamenDTO tipoExamen) {
		
		tipoExamenMedicoMapper.actualizar(tipoExamen);
		
		tipoExamenMedicoMapper.eliminarDetalle(tipoExamen.getIdExamenClinico());
		
		for (AtributoExamenClinicoDTO atr : tipoExamen.getAtributos()) {
			atr.setIdExamenClinico(tipoExamen.getIdExamenClinico());
			tipoExamenMedicoMapper.registrarDetalle(atr);
		}
	}
}
