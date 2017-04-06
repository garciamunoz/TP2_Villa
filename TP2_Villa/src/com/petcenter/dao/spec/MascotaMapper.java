package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.Mascota;

public interface MascotaMapper {

	int registrarMascota(Mascota mascota);
	List<Mascota> listaMascota(Map<String, Object> mapa);
	Mascota verMascota(int idMascota);
	int eliminarMascota(int idMascota);
	int actualizarMascota(Mascota mascota);
	
}
