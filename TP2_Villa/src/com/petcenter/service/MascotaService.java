package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.MascotaMapper;
import com.petcenter.dto.Mascota;

@Service
public class MascotaService {

	@Autowired
	MascotaMapper mascotaMapper;
	
	public int registrarMascota(Mascota Mascota){
		return mascotaMapper.registrarMascota(Mascota);
	}
	
	public List<Mascota> listaMascota
						(String idTipoDocumento, String nroDocumento, String codMascota,
						 String nomMascota, String apePaternoCliente, String apeMaternoCliente,
						 String codCliente, String nomCliente) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idTipoDocumento", idTipoDocumento);
		mapa.put("nroDocumento", nroDocumento);
		mapa.put("codMascota", codMascota);
		mapa.put("nomMascota", nomMascota);
		mapa.put("codCliente", codCliente);
		mapa.put("nomCliente", nomCliente);
		mapa.put("apePaternoCliente", apePaternoCliente);
		mapa.put("apeMaternoCliente", apeMaternoCliente);
		return mascotaMapper.listaMascota(mapa);
	}
	
	public Mascota verMascota(int idMascota){
		return mascotaMapper.verMascota(idMascota);
	}
	
	public int eliminarMascota(int idMascota){
		return mascotaMapper.eliminarMascota(idMascota);
	}
	
	public int actualizarMascota(Mascota mascota){
		return mascotaMapper.actualizarMascota(mascota);
	}
}
