package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.AtencionMedica;
import com.petcenter.dto.Diagnostico;
import com.petcenter.dto.Examen;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
public interface AtencionMedicaMapper {

	List<Examen> listaExamenes(); 
	List<Diagnostico> listaDiagnostico();
	int registrarAM(AtencionMedica atencionMedica);
	List<AtencionMedica> listaAM(Map<String, Object> mapa);
	AtencionMedica verAM(int idAM);
	int eliminarAM(int idAM);
	
}
