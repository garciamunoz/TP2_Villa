package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.Raza;

public interface RazaMapper {

	int registrarRaza(Raza raza);
	List<Raza> listaRaza(Map<String, Object> mapa);
	Raza verRaza(int idRAZA);
	int eliminarRaza(int idRAZA);
	int actualizarRaza(Map<String, Object> mapa);
	
}
