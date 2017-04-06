package com.petcenter.dao.spec;

import java.util.List;

import com.petcenter.dto.SeguimientoControl;

public interface SeguimientoControlMapper {

	List<SeguimientoControl> verServicioAtencionMedica();
	List<SeguimientoControl> verServicioPeluqueria();
	
}
