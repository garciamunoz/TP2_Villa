package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.DatosClienteMascota;

public interface HistoriaClinicaMapper {

	List<DatosClienteMascota> listaClienteMascota(Map<String, Object> mapa); 
	
}
