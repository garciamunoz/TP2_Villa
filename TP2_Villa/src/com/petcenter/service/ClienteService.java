package com.petcenter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcenter.dao.spec.ClienteMapper;
import com.petcenter.dto.Cliente;

@Service
public class ClienteService {

	@Autowired
	ClienteMapper clienteMapper;
	
	public int registrarCliente(Cliente cliente){
		return clienteMapper.registrarCliente(cliente);
	}
	
	public List<Cliente> listaCliente
						(String idTipoDocumento, String nroDocumento, String codCliente,
						 String nomCliente, String apePaternoCliente, String apeMaternoCliente) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("idTipoDocumento", idTipoDocumento);
		mapa.put("nroDocumento", nroDocumento);
		mapa.put("codCliente", codCliente);
		mapa.put("nomCliente", nomCliente);
		mapa.put("apePaternoCliente", apePaternoCliente);
		mapa.put("apeMaternoCliente", apeMaternoCliente);
		return clienteMapper.listaCliente(mapa);
	}
	
	public Cliente verCliente(int idCliente){
		return clienteMapper.verCliente(idCliente);
	}
	
	public int eliminarCliente(int idCliente){
		return clienteMapper.eliminarCliente(idCliente);
	}
	
	public int actualizarCliente(Cliente cliente){
		return clienteMapper.actualizarCliente(cliente);
	}
}
