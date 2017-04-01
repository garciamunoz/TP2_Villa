package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.DiagnosticoMapper;
import com.petcenter.dto.Diagnostico;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Service
public class DiagnosticoService {

	@Autowired
	DiagnosticoMapper diagnosticoMapper;
	
	public int registrarDiagnostico(Diagnostico diagnostico){
		return diagnosticoMapper.registrarDiagnostico(diagnostico);
	}
	
	public List<Diagnostico> listaDiagnostico(String idDIAG, String DESC) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idDIAG", idDIAG);
		mapa.put("DESC", DESC);
		return diagnosticoMapper.listaDiagnostico(mapa);
	}
	
	public Diagnostico verDiagnostico(int idDIAG){
		return diagnosticoMapper.verDiagnostico(idDIAG);
	}
	
	public int eliminarDiagnostico(int idDIAG){
		return diagnosticoMapper.eliminarDiagnostico(idDIAG);
	}
	
	public int actualizarDiagnostico(int idDIAG, String observacion){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idDIAG", idDIAG);
		mapa.put("observacion", observacion);
		return diagnosticoMapper.actualizarDiagnostico(mapa);
	}
}
