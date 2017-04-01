package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.EspecieMapper;
import com.petcenter.dto.Especie;

@Service
public class EspecieService {

	@Autowired
	EspecieMapper especieMapper;
	
	public int registrarEspecie(Especie especie){
		return especieMapper.registrarEspecie(especie);
	}
	
	public List<Especie> listaEspecie(String idESPE, String DESC) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idESPE", idESPE);
		mapa.put("DESC", DESC);
		return especieMapper.listaEspecie(mapa);
	}
	
	public Especie verEspecie(int idESPE){
		return especieMapper.verEspecie(idESPE);
	}
	
	public int eliminarEspecie(int idESPE){
		return especieMapper.eliminarEspecie(idESPE);
	}
	
	public int actualizarEspecie(int idESPE, String observacion){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idESPE", idESPE);
		mapa.put("observacion", observacion);
		return especieMapper.actualizarEspecie(mapa);
	}
}
