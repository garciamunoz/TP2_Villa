package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.ProcedimientoMapper;
import com.petcenter.dto.Procedimiento;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Service
public class ProcedimientoService {

	@Autowired
	ProcedimientoMapper procedimientoMapper;
	
	public int registrarProcedimiento(Procedimiento procedimiento){
		return procedimientoMapper.registrarProcedimiento(procedimiento);
	}
	
	public List<Procedimiento> listaProcedimiento(String idProcedimiento, String idAM) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idProcedimiento", idProcedimiento);
		mapa.put("idAM", idAM);
		return procedimientoMapper.listaProcedimiento(mapa);
	}
	
	public Procedimiento verProcedimiento(int idProcedimiento){
		return procedimientoMapper.verProcedimiento(idProcedimiento);
	}
	
	public int eliminarProcedimiento(int idProcedimiento){
		return procedimientoMapper.eliminarProcedimiento(idProcedimiento);
	}
	
	public int actualizarProcedimiento(int idProcedimiento, String tipoProcedimiento, String descripcion, String observacion){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idProcedimiento", idProcedimiento);
		mapa.put("tipoProcedimiento", tipoProcedimiento);
		mapa.put("descripcion", descripcion);
		mapa.put("observacion", observacion);
		return procedimientoMapper.actualizarProcedimiento(mapa);
	}
}
