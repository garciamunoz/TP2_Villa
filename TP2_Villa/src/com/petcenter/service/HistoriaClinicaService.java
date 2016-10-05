package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.HistoriaClinicaMapper;
import com.petcenter.dto.DatosClienteMascota;

@Service
public class HistoriaClinicaService {

	@Autowired
	HistoriaClinicaMapper historiaClinicaMapper;
	
	public List<DatosClienteMascota> listaClienteMascota(String tipoDoc, String numDoc){
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("tipoDoc", tipoDoc);
		mapa.put("numDoc", numDoc);
		return historiaClinicaMapper.listaClienteMascota(mapa);
	}
}
