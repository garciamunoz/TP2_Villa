package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.RazaMapper;
import com.petcenter.dto.Raza;

@Service
public class RazaService {

	@Autowired
	RazaMapper razaMapper;
	
	public int registrarRaza(Raza raza){
		return razaMapper.registrarRaza(raza);
	}
	
	public List<Raza> listaRaza(String idRAZA, String DESC) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idRAZA", idRAZA);
		mapa.put("DESC", DESC);
		return razaMapper.listaRaza(mapa);
	}
	
	public Raza verRaza(int idRAZA){
		return razaMapper.verRaza(idRAZA);
	}
	
	public int eliminarRaza(int idRAZA){
		return razaMapper.eliminarRaza(idRAZA);
	}
	
	public int actualizarRaza(int idRAZA, String observacion, String idEspecie){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idRAZA", idRAZA);
		mapa.put("observacion", observacion);
		mapa.put("idEspecie", idEspecie);
		return razaMapper.actualizarRaza(mapa);
	}
}
