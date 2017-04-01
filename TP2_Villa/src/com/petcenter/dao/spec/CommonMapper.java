package com.petcenter.dao.spec;

import java.util.List;

import com.petcenter.dto.AtributoDTO;
import com.petcenter.dto.TipoDocDTO;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
public interface CommonMapper {

	List<TipoDocDTO> listaTipoDoc();
	
	
	List<AtributoDTO> listaTodosAtributos();
	
}
