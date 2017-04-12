package com.petcenter.dao.spec;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.petcenter.dto.PrecioExamenDTO;
import com.petcenter.dto.TipoExamenDTO;

public interface PrecioExamenMapper {
	
	List<TipoExamenDTO> consultarPreciosExamenes(@Param("nombreExamenClinico") String nombreExamenClinico, 
												 @Param("idMoneda") String idMoneda, 
												 @Param("fechaInicial") String fechaInicial, 
												 @Param("fechaFinal") String fechaFinal);
	
	PrecioExamenDTO recuperarPrecioExamen(@Param("idExamenClinico") String idExamenClinico, 
									 	  @Param("fechaInicial") String fechaInicial, 
									      @Param("fechaFinal") String fechaFinal);
	
	int cantidadPreciosExamenRango(@Param("idExamenClinico") String idExamenClinico, 
							 	   @Param("fechaInicial") String fechaInicial, 
							       @Param("fechaFinal") String fechaFinal);
	
	PrecioExamenDTO recuperarPrecioExamenPrevio(@Param("idExamenClinico") String idExamenClinico);
	
	void actualizarPrecioExamenPrevio(PrecioExamenDTO precioExamen);
	
	void registrarPrecioExamen(PrecioExamenDTO precioExamen);
	
	void actualizarPrecioExamen(PrecioExamenDTO precioExamen);
	
	PrecioExamenDTO recuperarPrecioExamenVigente(@Param("idExamenClinico") String idExamenClinico);
	
	List<PrecioExamenDTO> listarPreciosExamen(@Param("idExamenClinico") String idExamenClinico);

}
