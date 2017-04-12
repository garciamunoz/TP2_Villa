package com.petcenter.service;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.PrecioExamenMapper;
import com.petcenter.dto.PrecioExamenDTO;
import com.petcenter.dto.TipoExamenDTO;

@Service
public class PrecioExamenService {

	@Autowired
	PrecioExamenMapper precioExamenMapper;

	public List<TipoExamenDTO> consultarPreciosExamenes(String nombreExamenClinico, String idMoneda,
			String fechaInicial, String fechaFinal) {
		return precioExamenMapper.consultarPreciosExamenes(nombreExamenClinico, idMoneda, fechaInicial, fechaFinal);
	}

	public PrecioExamenDTO recuperarPrecioExamen(String idExamenClinico, String fechaInicial, String fechaFinal) {
		return precioExamenMapper.recuperarPrecioExamen(idExamenClinico, fechaInicial, fechaFinal);
	}

	public boolean existenPreciosExamenRango(String idExamenClinico, String fechaInicial, String fechaFinal) {
		int cantidad = precioExamenMapper.cantidadPreciosExamenRango(idExamenClinico, fechaInicial, fechaFinal);
		return cantidad > 0;
	}
	
	public void registrarPrecioExamen(PrecioExamenDTO precioExamen) {
		PrecioExamenDTO precioExamenPrevio = precioExamenMapper.recuperarPrecioExamenPrevio(precioExamen.getIdExamenClinico());
		
		if (precioExamenPrevio != null) {
			Calendar cal = Calendar.getInstance();
		    cal.setTime(precioExamen.getFechaInicial());
		    cal.add(Calendar.DAY_OF_MONTH, -1);
		    precioExamenPrevio.setFechaFinal2(cal.getTime());
		    precioExamenMapper.actualizarPrecioExamenPrevio(precioExamenPrevio);
		}
		
		precioExamen.setIndVigente("V");
		precioExamenMapper.registrarPrecioExamen(precioExamen);
	}
	
	public void actualizarPrecioExamen(PrecioExamenDTO precioExamen) {
		precioExamenMapper.actualizarPrecioExamen(precioExamen);
	}
	
	public PrecioExamenDTO recuperarPrecioExamenVigente(String idExamenClinico) {
		return precioExamenMapper.recuperarPrecioExamenVigente(idExamenClinico);
	}
	
	public List<PrecioExamenDTO> listarPreciosExamen(String idExamenClinico) {
		return precioExamenMapper.listarPreciosExamen(idExamenClinico);
	}

}
