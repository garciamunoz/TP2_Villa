package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.RecetaMapper;
import com.petcenter.dto.Receta;
import com.petcenter.dto.RecetaDetalle;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
@Service
public class RecetaService {

	@Autowired
	RecetaMapper RecetaMapper;
	
	public int registrarReceta(Receta receta){
		return RecetaMapper.registrarReceta(receta);
	}
	
	public int registrarRecetaDetalle(RecetaDetalle recetaDetalle){
		return RecetaMapper.registrarRecetaDetalle(recetaDetalle);
	}
	
	public List<Receta> listaReceta(String idReceta, String idAM) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idReceta", idReceta);
		mapa.put("idAM", idAM);
		return RecetaMapper.listaReceta(mapa);
	}
	
	public List<RecetaDetalle> listaRecetaDetalle(String idReceta) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idReceta", idReceta);
		return RecetaMapper.listaRecetaDetalle(mapa);
	}
	
	public Receta verReceta(int idReceta){
		return RecetaMapper.verReceta(idReceta);
	}
	
	public int eliminarReceta(int idReceta){
		return RecetaMapper.eliminarReceta(idReceta);
	}
	
	public int eliminarRecetaDetalle(int idReceta){
		return RecetaMapper.eliminarRecetaDetalle(idReceta);
	}
	
	public int actualizarReceta(int idReceta, String observacion){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idReceta", idReceta);
		mapa.put("observacion", observacion);
		return RecetaMapper.actualizarReceta(mapa);
	}
}
