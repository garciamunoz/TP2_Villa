package com.petcenter.laboratorio.dao.spec;

import java.util.List;

import com.petcenter.laboratorio.dto.TipoExamenDTO;

public interface TipoExamenMedicoMapper {
	
	List<TipoExamenDTO> buscarTiposExamen();

}
