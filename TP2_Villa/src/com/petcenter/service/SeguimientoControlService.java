package com.petcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.SeguimientoControlMapper;
import com.petcenter.dto.SeguimientoControl;

@Service
public class SeguimientoControlService {

	@Autowired
	SeguimientoControlMapper seguimientoControlMapper;
	
	public List<SeguimientoControl> verServicioAtencionMedica(){
		return seguimientoControlMapper.verServicioAtencionMedica();
	}
	public List<SeguimientoControl> verServicioPeluqueria(){
		return seguimientoControlMapper.verServicioPeluqueria();
	}
	
}
