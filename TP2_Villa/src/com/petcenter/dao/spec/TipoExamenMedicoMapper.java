package com.petcenter.dao.spec;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.petcenter.dto.AtributoExamenClinicoDTO;
import com.petcenter.dto.TipoExamenDTO;

public interface TipoExamenMedicoMapper {
	
	List<TipoExamenDTO> buscarTiposExamen(@Param("nom") String nombre,@Param("desc") String descripcion,@Param("est") String est,@Param("esp")String esp);
	
	int generarNumero();
	
	void registrar(TipoExamenDTO tipoExamen);
	
	void registrarDetalle(AtributoExamenClinicoDTO atributoExamenClinico);
	
	TipoExamenDTO recuperarTipoExamen(String idExamenClinico);
	
	List<AtributoExamenClinicoDTO> recuperarTipoExamenDetalle(String idExamenClinico);
	
	void actualizar(TipoExamenDTO tipoExamen);
	
	void eliminarDetalle(String idExamenClinico);
 
}
