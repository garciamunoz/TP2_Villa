package com.petcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.CommonMapper;
import com.petcenter.dto.AtributoDTO;
import com.petcenter.dto.MonedaDTO;
import com.petcenter.dto.TipoDocDTO;

@Service
public class CommonService {

	@Autowired
	CommonMapper commonMapper;
	
	public List<TipoDocDTO> listaTipoDoc(){
		return commonMapper.listaTipoDoc();
	}
	
	public List<AtributoDTO> listaTodosAtributos() {
		return commonMapper.listaTodosAtributos();
	}
	
	public List<MonedaDTO> listaMonedas() {
		return commonMapper.listaMonedas();
	}
}
