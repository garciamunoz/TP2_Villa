package com.petcenter.dao.spec;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.petcenter.dto.DetalleSolicitudExamenClinicoDTO;
import com.petcenter.dto.SolicitudExamenClinicoDTO;
import com.petcenter.dto.TipoExamPrecioExamVigDTO;

public interface SolicitudExamenMapper {
	
	List<SolicitudExamenClinicoDTO> consultarSolicitudesExamenes(@Param("idSolicitudexamen") String idSolicitudexamen, 
																 @Param("idCliente") int idCliente, 
																 @Param("fechaInicial") String fechaInicial, 
																 @Param("fechaFinal") String fechaFinal);
	
	SolicitudExamenClinicoDTO recuperarAtencionMedica(@Param("idAM") int idAM);
	
	int generarNumero();
	
	void registrarSolicitudExamenClinico(SolicitudExamenClinicoDTO sec);
	
	void eliminarDetalle(@Param("idSolicitudexamen") String idSolicitudexamen);
	
	void registrarDetalle(DetalleSolicitudExamenClinicoDTO detalle);
	
	List<TipoExamPrecioExamVigDTO> consultarTipoExamPrecioExamVig(@Param("idExamenClinico") String idExamenClinico, 
																  @Param("nombreExamenClinico") String nombreExamenClinico);
	
	List<DetalleSolicitudExamenClinicoDTO> recuperarDetalle(@Param("idSolicitudexamen") String idSolicitudexamen);
	
	void actualizarSolicitudExamenClinico(SolicitudExamenClinicoDTO sec);

}
