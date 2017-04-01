package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.Diagnostico;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
public interface DiagnosticoMapper {

	int registrarDiagnostico(Diagnostico diagnostico);
	List<Diagnostico> listaDiagnostico(Map<String, Object> mapa);
	Diagnostico verDiagnostico(int idDIAG);
	int eliminarDiagnostico(int idDIAG);
	int actualizarDiagnostico(Map<String, Object> mapa);
	
}
