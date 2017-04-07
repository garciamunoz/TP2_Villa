package com.petcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petcenter.dao.spec.EstadoMapper;
import com.petcenter.dao.spec.SolicitudExamenMapper;
import com.petcenter.dto.DetalleSolicitudExamenClinicoDTO;
import com.petcenter.dto.EstadoDTO;
import com.petcenter.dto.SolicitudExamenClinicoDTO;
import com.petcenter.dto.TipoExamPrecioExamVigDTO;

@Service
public class SolicitudExamenService {

	@Autowired
	SolicitudExamenMapper solicitudExamenMapper;
	
	@Autowired
	EstadoMapper estadoMapper;

	public List<SolicitudExamenClinicoDTO> consultarSolicitudesExamenes(String idSolicitudexamen, int idCliente,
																		String fechaInicial, String fechaFinal) {
		return solicitudExamenMapper.consultarSolicitudesExamenes(idSolicitudexamen, idCliente, fechaInicial, fechaFinal);
	}
	
	public List<EstadoDTO> listaEstados2() {
		return estadoMapper.listaEstados2();
	}
	
	public SolicitudExamenClinicoDTO recuperarAtencionMedica(int idAM) {
		return solicitudExamenMapper.recuperarAtencionMedica(idAM);
	}
	
	@Transactional
	public String registrarSolicitudExamen(SolicitudExamenClinicoDTO sec) {
		int nuevo = solicitudExamenMapper.generarNumero();
		String strNuevo = String.format("%04d", nuevo);
		
		sec.setIdSolicitudexamen(strNuevo);
		
		solicitudExamenMapper.registrarSolicitudExamenClinico(sec);
		
		solicitudExamenMapper.eliminarDetalle(strNuevo);
		
		int count = 0;
		for (DetalleSolicitudExamenClinicoDTO dsec : sec.getDetalle()) {
			dsec.setIdSolicitudexamen(strNuevo);
			dsec.setItem(++count);
			solicitudExamenMapper.registrarDetalle(dsec);
		}
		
		return strNuevo;
	}
	
	public List<TipoExamPrecioExamVigDTO> consultarTipoExamPrecioExamVig(String idExamenClinico, String nombreExamenClinico) {
		return solicitudExamenMapper.consultarTipoExamPrecioExamVig(idExamenClinico, nombreExamenClinico);
	}
	
	public List<DetalleSolicitudExamenClinicoDTO> recuperarDetalle(String idSolicitudexamen) {
		return solicitudExamenMapper.recuperarDetalle(idSolicitudexamen);
	}
	
	public void actualizarSolicitudExamenClinico(SolicitudExamenClinicoDTO sec) {
		solicitudExamenMapper.actualizarSolicitudExamenClinico(sec);
	}

}
