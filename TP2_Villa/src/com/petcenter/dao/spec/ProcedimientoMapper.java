package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.Procedimiento;

public interface ProcedimientoMapper {

	int registrarProcedimiento(Procedimiento procedimiento);
	List<Procedimiento> listaProcedimiento(Map<String, Object> mapa);
	Procedimiento verProcedimiento(int idProcedimiento);
	int eliminarProcedimiento(int idProcedimiento);
	int actualizarProcedimiento(Map<String, Object> mapa);
	
}
