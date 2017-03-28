package com.petcenter.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.EspecialidadMapper;
import com.petcenter.dao.spec.EstadoMapper;
import com.petcenter.dao.spec.EstandarMapper;
import com.petcenter.dao.spec.NormativaMapper;
import com.petcenter.dao.spec.PrecioMapper;
import com.petcenter.dao.spec.TipoExamenMedicoMapper;
import com.petcenter.dto.EspecialidadDTO;
import com.petcenter.dto.EstadoDTO;
import com.petcenter.dto.EstandarDTO;
import com.petcenter.dto.NormativaDTO;
import com.petcenter.dto.PrecioDTO;
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
	
	public List<EspecialidadDTO> listarEspecialidades(){
		return especialidadMapper.listarEspecialidades();
	}
	public List<EstadoDTO> listarEstados(){
		return estadoMapper.listaEstados();
	}
	public List<TipoExamenDTO> buscarTiposExamen(String nombre,String descripcion,Integer est,Integer esp){
		return tipoExamenMedicoMapper.buscarTiposExamen(nombre, descripcion, est, esp);
	}
	public List<NormativaDTO> listarNormativa(){
		return normativaMapper.listarNormativa();
	}
	public List<EstandarDTO> listaEstandares(){
		return estandarMapper.listaEstandares();
	}
	public List<PrecioDTO> listarPrecios(String mon,String startDate,String endDate) throws Exception{
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String reformattedStr = myFormat.format(fromUser.parse(startDate));
		 String reformattedStrEdnd = myFormat.format(fromUser.parse(endDate));
		return precioMapper.listarPrecios(mon,reformattedStr,reformattedStrEdnd);
	}
}
