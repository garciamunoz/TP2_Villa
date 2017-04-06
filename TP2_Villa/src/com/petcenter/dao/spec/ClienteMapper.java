package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.Cliente;

public interface ClienteMapper {

	int registrarCliente(Cliente cliente);
	List<Cliente> listaCliente(Map<String, Object> mapa);
	Cliente verCliente(int idCliente);
	int eliminarCliente(int idCliente);
	int actualizarCliente(Cliente cliente);
	
}
