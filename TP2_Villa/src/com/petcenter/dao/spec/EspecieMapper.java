package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.Especie;

public interface EspecieMapper {

	int registrarEspecie(Especie especie);
	List<Especie> listaEspecie(Map<String, Object> mapa);
	Especie verEspecie(int idESPE);
	int eliminarEspecie(int idESPE);
	int actualizarEspecie(Map<String, Object> mapa);
	
}
