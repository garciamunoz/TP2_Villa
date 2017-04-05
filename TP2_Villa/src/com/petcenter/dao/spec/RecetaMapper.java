package com.petcenter.dao.spec;

import java.util.List;
import java.util.Map;

import com.petcenter.dto.Receta;
import com.petcenter.dto.RecetaDetalle;

/**
 * 
 * @author Gianmarco Malex Trillo
 *
 */
public interface RecetaMapper {

	int registrarReceta(Receta receta);
	List<Receta> listaReceta(Map<String, Object> mapa);
	Receta verReceta(int idReceta);
	int eliminarReceta(int idReceta);
	int actualizarReceta(Map<String, Object> mapa);
	
	List<RecetaDetalle> listaRecetaDetalle(Map<String, Object> mapa);
	int registrarRecetaDetalle(RecetaDetalle detalleReceta);
	int eliminarRecetaDetalle(int idReceta);
	
}
