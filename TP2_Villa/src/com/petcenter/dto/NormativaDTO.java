package com.petcenter.dto;

public class NormativaDTO {

	private String idNormativa;
	private String nombreNormativa; 
	private EstadoDTO estado;
	
	public NormativaDTO(){}

	public NormativaDTO(String idNormativa, String nombreNormativa, EstadoDTO estado) {
		super();
		this.idNormativa = idNormativa;
		this.nombreNormativa = nombreNormativa;
		this.estado = estado;
	}

	public String getIdNormativa() {
		return idNormativa;
	}

	public void setIdNormativa(String idNormativa) {
		this.idNormativa = idNormativa;
	}

	public String getNombreNormativa() {
		return nombreNormativa;
	}

	public void setNombreNormativa(String nombreNormativa) {
		this.nombreNormativa = nombreNormativa;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	
}
