package com.petcenter.laboratorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.laboratorio.dao.spec.EspecialidadMapper;
import com.petcenter.laboratorio.dao.spec.EstadoMapper;
import com.petcenter.laboratorio.dto.EspecialidadDTO;
import com.petcenter.laboratorio.dto.EstadoDTO;

@Service
public class ActualizarTipoExamenMedicoService {

	@Autowired
	private EspecialidadMapper especialidadMapper;
	@Autowired
	private EstadoMapper estadoMapper;
	
	public List<EspecialidadDTO> listarEspecialidades(){
		return especialidadMapper.listarEspecialidades();
	}
	public List<EstadoDTO> listarEstados(){
		return estadoMapper.listaEstados();
	}
}
