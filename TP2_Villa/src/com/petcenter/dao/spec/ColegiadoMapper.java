package com.petcenter.dao.spec;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.petcenter.dto.ColegiadoDTO;

public interface ColegiadoMapper {
	
	List<ColegiadoDTO> consultarColegiados(@Param("numeroColegiatura") String numeroColegiatura, 
										   @Param("nombre") String nombre, 
										   @Param("apellidoPaterno") String apellidoPaterno, 
										   @Param("apellidoMaterno")String apellidoMaterno);
	
	ColegiadoDTO recuperarColegiado(@Param("numeroColegiatura") String numeroColegiatura);

}
