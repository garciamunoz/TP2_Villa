package com.petcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.ColegiadoMapper;
import com.petcenter.dto.ColegiadoDTO;

@Service
public class ColegiadoService {

	@Autowired
	ColegiadoMapper colegiadoMapper;

	public List<ColegiadoDTO> consultarColegiados(String numeroColegiatura, String nombre, String apellidoPaterno,
			String apellidoMaterno) {
		return colegiadoMapper.consultarColegiados(numeroColegiatura, nombre, apellidoPaterno, apellidoMaterno);
	}
	
	public ColegiadoDTO recuperarColegiado(String numeroColegiatura) {
		return colegiadoMapper.recuperarColegiado(numeroColegiatura);
	}

}
